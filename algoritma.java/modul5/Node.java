package modul5;

public class Node {

    Object data;
    Node next;
    Node prev;

    public Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}