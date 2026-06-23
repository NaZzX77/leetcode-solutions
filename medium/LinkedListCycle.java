public class LinkedListCycle {

    private Node head;

    public Node detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}