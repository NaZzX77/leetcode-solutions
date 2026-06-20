package LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }


        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public LinkedList() {
        this.size=0;
    }
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;

        if(tail==null) tail=head;
        size++;

    }
    public void insertLast(int value){
        Node node = new Node(value);

        if(head == null){
            insertFirst(value);
        }
        else{
            tail.next = node;
            tail = node;
        }

        size++;
    }
    public void insertAtIndex(int value,int index){
        if(head==null || index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node node=new Node(value);
        Node temp=head;
        for (int i = 0; i < index-1; i++) {
            temp=temp.next;
        }
            node.next = temp.next;
            temp.next = node;
  //        Node sendForward=temp.next;
  //        temp.next=node;
  //        node.next=sendForward;
  //        size++;
        //sendForward.next=sendForward.next;

    }
    public void deleteFirst(){
        if(size==1){
            head=tail=null;
            size--;
            return;
        }
        if(size==0){
            return;
        }
        head=head.next;
        size--;
    }
    public void deleteLast(){
        if(size==1){
            head=tail=null;
            size--;
            return;
        }
        if(size==0){
            return;
        }
        Node temp=head;
        while(temp.next != tail){
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        size--;
    }
    public void deleteAtIndex(int index){
        //add edge case for valid indexes.
        if(size==0){
            return;
        }
        if(index==0) {deleteFirst(); return;}
        if(index==size-1) {deleteLast(); return;}

        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp= temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public Node find(int value){
        Node temp=head;
        while(temp!=null){
            if(temp.value==value){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public Node get(int index){
        if(index<0 || index>size-1) return null;
        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }
    public void reverse(){
        Node previous = null;
        Node oldHead=head;
        Node current = head;
        while(current != null){
            Node nextNode=current.next;
            current.next=previous;
            previous=current;
            current=nextNode;


        }
        head=previous;
        tail=oldHead;
    }
    //insert using recursion
    //using only head(tail and size do not exist)
    public Node insertUsingrecursionHelper(int value,int index,Node head){
         if(index==0){
            Node node = new Node(value);
            node.next=head;
            return node;
         }
         head.next= insertUsingrecursionHelper(value,index-1,head.next);
         return head;
    }
    public void insertUsingrecursion(int value, int index) {
        head = insertUsingrecursionHelper(value, index, head);
    }
    public static LinkedList merged(LinkedList list1,LinkedList list2){
        Node f=list1.head;
        Node s=list2.head;
        LinkedList merged= new LinkedList();
        while(f!=null && s!=null){
            if(f.value<s.value){
                merged.insertLast(f.value);
                f=f.next;
            }
            else{
                merged.insertLast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            merged.insertLast(f.value);
            f=f.next;
        }
        while(s!=null){
            merged.insertLast(s.value);
            s=s.next;
        }
        return merged;
    }

}
