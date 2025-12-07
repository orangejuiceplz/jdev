package types;

import static utils.sorts.SortUtils.*;

public class LinkedList {

    Node head;
    Node tail;
    private int size = 0;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        protected int getData() {
            return this.data;
        }
        protected void setNext(Node next) {
            this.next = next;
        }
        protected Node getNext() {
            return this.next;
        }
        protected void setData(int data) {
            this.data = data;
        }

    }

    /**
     *
     * Add a value into the Linked List
     *
     * @param data
     * specified data value (int) to be added to the LinkedList
     *
     */

    public void append(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
    }

    /**
     *
     * Prints the contents of the linked list. Shows pointers to next value.
     *
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> " );
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return this.size;
    }

    /**
     *
     * Converts LinkedList object to an array,
     *
     * @return int[] equivalent of the LinkedList object
     *
     */
    private int[] toArray() {
        Node current = this.head;
        int[] arr = new int[this.getSize()];
        for (int i = 0; i < arr.length; i++) {
            if (current == null) break;
            arr[i] = current.getData();
            current = current.getNext();
        }
        return arr;
    }

    public static int[] toArray(LinkedList list) {
        return list.toArray();
    }



    /**
     *
     * Updates the direct values of the LinkedList so that it is sorted. Does not change
     * where each node is pointing to.
     *
     * @param arr
     * array of sorted values
     */
    public void appendBack(int[] arr) {
        Node current = head;

        for (int i : arr) {
            if (current == null) break;
            current.setData(i);
            current = current.getNext();
        }
    }
}
