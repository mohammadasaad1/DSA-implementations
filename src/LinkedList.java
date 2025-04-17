public class LinkedList {
    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    private Node first;
    private Node last;

    public void addLast(int data) {
        var node = new Node(data);

        if(first == null)
            first = last = node ;

        else {
            last.next = node;
            last = node;
        }
    }

}
