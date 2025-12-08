package types;

public class SinglyLinkedList {

    Node head;
    Node tail;
    private int size = 0;

    static class Node {
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

    public int getSize() {
        return this.size;
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
     * inserts data at the given position
     *
     * @param position
     * index to be inserted at
     *
     * @param data
     * value to be inserted at position
     *
     */
    public void insertAt(int position, int data) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }


        // if the position is at the end of the array, just call append since it's the same thing
        if (position == size) {
            append(data);
            return;
        }

        Node newNode = new Node(data);

        /*
         * strategy:
         *          1. if the position is at index 0, set new node's next node to HEAD
         *          2. set head equal to the value of new Node
         *          3. increase the size
         */
        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    /**
     *
     * deletes the specified index
     *
     * @param position
     * index to delete
     * @throws IndexOutOfBoundsException if either {@code position < 0} pr {@code position > size - 1}
     */
    public void deleteAt(int position) {


        if (position < 0 || position > size - 1) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // if the position is at the start, set head to the next element
        // if the size is 1 (1 element), then set both head and tail to null since they point to the same value
        if (position == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
            }
            size--;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i ++) {
            current = current.getNext();
        }

        // if the position is to delete the last element, set the next element to null and update tail to current
        if (position == size - 1) {
            current.setNext(null);
            tail = current;
            size--;
            return;
        }
        // set currents next node to currents next, next node (so the middle next is dereferenced)
        // e.g 4 -> 5 -> 6
        //     4 X -> 5 X -> 6
        //     4 -> 6
        //     5 gets collected by java's garbage collection
        current.setNext(current.getNext().getNext());
        size--;
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

    public static int[] toArray(SinglyLinkedList list) {
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

    // a
    /**
     * reverses the linked list
     * not very interesting
     */
    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.getNext();

            current.setNext(prev);

            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }
}
