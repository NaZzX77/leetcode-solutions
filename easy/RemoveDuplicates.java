package LinkedList.LeetCode;

public class RemoveDuplicates{

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;

        public void insert(int value) {
            Node node = new Node(value);

            if (head == null) {
                head = tail = node;
                return;
            }

            tail.next = node;
            tail = node;
        }

        public void removeDuplicates() {
            if (head == null) {
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                if (temp.value == temp.next.value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
        }

        public void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.println("END");
        }
    }

    static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(3);
        ll.insert(4);
        ll.insert(4);

        System.out.println("Before:");
        ll.display();

        ll.removeDuplicates();

        System.out.println("After:");
        ll.display();
    }
}