package types;

public class DoublyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public int getData() {
            return this.data;
        }
        public Node getNext() {
            return this.next;
        }
        public Node getPrev() {
            return this.prev;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
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
        newNode.setPrev(tail);
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
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        /*
         *  strategy:
         *           1. connect newNode to neighbors
         *           2. connect neighbors to newNode
         *
         */
        Node nodeAfter = current.getNext();
        newNode.setNext(nodeAfter);
        newNode.setPrev(current);

        if (nodeAfter != null) {
            nodeAfter.setPrev(newNode);
        }
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
                head.setPrev(null);
            }
            size--;
            return;
        }
        // if the position is to delete the last element, just call deleteLast and return
        if (position == size - 1) {
            deleteLast();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i ++) {
            current = current.getNext();
        }
        Node nodeToDel = current.getNext();
        Node nodeAfter = nodeToDel.getNext();

        current.setNext(nodeAfter);

        if (nodeAfter != null) {
            nodeAfter.setPrev(current);
        }

        size--;
    }

    public void deleteLast() {
        if (tail == null) return;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        tail = tail.getPrev();
        tail.setNext(null);
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

    public void displayBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.getData() + " <-> ");
            current = current.getPrev();
        }
        System.out.println("null {END}");
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

    public static int[] toArray(DoublyLinkedList list) {
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

    /**
     * reverses the linked list
     * not very interesting
     */
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            // next node is in previous so update current to that
            current = current.getPrev();
        }

        if (temp != null) {
            head = temp.getPrev();
        }

    }

}
