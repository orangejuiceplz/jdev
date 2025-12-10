package types.generic;

public class SinglyLinkedList<T> {

    Node<T> head;
    private int size;

    public SinglyLinkedList() {
        // default because he wants it
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        add(size, value);
    }

    public void add(int index, T value) {
        checkBounds(index, size);

        if (index == 0) {
            addFirst(value);
            return;
        }
        Node<T> previous = getNode(index - 1);
        Node<T> newNode = new Node<>(value);

        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
        size++;
    }

    public void append(T value) {
        addLast(value);
    }

    public T replace(int index, T value) {
        checkBounds(index, size - 1);

        Node<T> current = getNode(index);
        T valOfReplaced = current.getValue();
        current.setValue(value);
        return valOfReplaced;
    }

    public int search(T value) {

        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (isSafe(value, current.getValue())) return i;
            current = current.getNext();
        }
        return -1;
    }

    public void remove(int index) {
        checkBounds(index, size - 1);
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<T> parent = getNode(index - 1);
        Node<T> child = parent.getNext(); // or you can just do parent.setNext(parent.getNext().getNext()) ig
        parent.setNext(child.getNext());
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
        remove(size - 1);
    }

    public int removeValue(T value) {
        int index = search(value);

        if (index != -1) {
            remove(index);
            return index;
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

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
    private void checkBounds(int index, int bound) {
        if (index < 0 || index > bound) throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }
    private boolean isSafe(T target, T currentValue) {
        if (target == null) return (currentValue == null);
        return target.equals(currentValue);
    }


}

