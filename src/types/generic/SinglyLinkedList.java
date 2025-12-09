package types.generic;

public class SinglyLinkedList<T> {

    Node<T> head;
    private int size;

    public SinglyLinkedList() {
        // default because he wants it
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            size++;
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        size++;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Out of Bounds index");

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }


    public void append(T value) {
        addLast(value);
    }

    public T replace(int index, T value) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("OBO");

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T valOfReplaced = current.getValue();
        current.setValue(value);
        return valOfReplaced;
    }

    public int search(T value) {

        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            boolean found;
            if (value == null) {
                found = (current.getValue() == null);
            } else {
                found = (current.getValue() != null && current.getValue().equals(value));
            }
            if (found) {
                return i;
            } else {
                current = current.getNext();
            }
        }

        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index Out of Bounds");

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        // we're setting current to the next node's child

        current.setNext(current.getNext().getNext());
        size--;
    }

    public void removeFirst() {
        if (head == null) return;

        head = head.getNext();
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < size - 2; i++) {
            current = current.getNext();
        }
        current.setNext(null);
        size--;
    }

    public int removeValue(T value) {
        if (head == null && value != null) return -1;
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            T currentVal = current.getValue();
            boolean found;

            if (value == null) {
                found = (currentVal == null);
            } else {
                found = value.equals(currentVal);
            }

            if (found) {
                remove(i);
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }


    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public int getSize() {
        return this.size;
    }




}

