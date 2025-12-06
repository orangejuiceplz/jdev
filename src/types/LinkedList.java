package types;

import static utils.MergeSort.*;

public class LinkedList {
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
        protected void setData(int data) {this.data = data; }

    }

    Node head;
    private int size = 0;

    public void append(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);

    }

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

    public void sort() {

        Node current = this.head;

        int[] arr = new int[this.getSize()];
        for (int i = 0; i < arr.length; i++) {
            if (current == null) break;
            arr[i] = current.getData();
            current = current.getNext();
        }

        mergeSort(arr);
        appendBack(arr);
    }
    private void appendBack(int[] arr) {

        Node current = head;

        for (int i : arr) {
            if (current == null) break;
            current.setData(i);
            current = current.getNext();
        }
    }
}
