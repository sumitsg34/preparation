package org.learn.preparation.greeks;

public class LinkedListImpl {

    Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(value);
        }
    }

    public Node getHead() {
        return head;
    }

    public void display() {
        Node curr = head;
        //System.out.println();
        while (curr != null) {
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void addAfter(int after, int value) {
        Node curr = head;
        while (curr.data != after) {
            curr = curr.next;
        }
        // only if found
        Node temp = curr.next;
        curr.next = new Node(value);
        curr.next.next = temp;
        System.out.print("Updated list:");
        display();
    }

    public void delete(int value) {
        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (curr.data == value) {
                if (curr == head) {
                    head = head.next;
                    break;
                }
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.print("Updated list:");
        display();
    }

    public Node reverseByRecursion(Node node) {
        if (node.next == null) {
            this.head = node;
            return node;
        }
        Node curr = reverseByRecursion(node.next);
        curr.next = node;
        node.next = null;
        return node;
    }

    public void reverseUsingLinks() {
        Node curr = head.next;
        Node prev = head;
        prev.next = null;
        while (curr != null) {
            Node temp = curr.next;
            if (temp == null) {
                head = curr;
                head.next = prev;
                break;
            }
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    public Node rotate(Node head, int k) {
        // add code here.
        Node curr = head;
        // 1 2 3 4 5 6
        while (k > 1) {
            if (curr.next == null) {
                curr = head;
            } else
                curr = curr.next;
            k--;
        }
        // now
        Node newHead = curr.next; // new head
        if (newHead != null) {
            // move till last
            curr.next = null;
            curr = newHead;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = head;
            this.head = newHead;
            return newHead;
        } else {
            return head;
        }

    }

    /**
     * input node is to be deleted
     *
     * @param node //43 50 75 91 55 100 58 5 34 21 62 69 45
     */
    void deleteNode(Node node) {
        // 1 2 3 4 5
        Node last = node;
        while (node.next != null) {
            node.data = node.next.data;
            last = node;
            node = node.next;
        }
        last.next = null;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();

//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.add(7);
//        linkedList.add(8);
        //43 50 75 91 55 100 58 5 34 21 62 69 45
        linkedList.add(43);
        linkedList.add(50);
        linkedList.add(75);
        linkedList.add(91);
        linkedList.add(55);
        linkedList.add(100);
        linkedList.add(58);
        linkedList.add(5);
        linkedList.add(34);
        linkedList.add(21);
        linkedList.add(62);
        linkedList.add(69);
        linkedList.add(45);

        linkedList.display();
        Node node = linkedList.getHead();
        while (node != null) {
            if (node.data == 100)
                break;
            node = node.next;
        }

        linkedList.deleteNode(node);
        System.out.println("Reversed:");
        linkedList.display();


    }

}
