package types.generic;

class Node<T> {
    Node<T> next;
    T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    protected T getValue() {
        return this.value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    protected Node<T> getNext() {
        return this.next;
    }

    protected void setNext(Node<T> next) {
        this.next = next;
    }
}
