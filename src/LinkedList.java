import java.util.NoSuchElementException;

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
    private int size;

    public boolean isEmpty() {
        return first == null;
    }
    public void addLast(int data) {
        var node = new Node(data);

        if(isEmpty())
            first = last = node ;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }
    public void addFirst(int data) {
        var node = new Node(data);
        if (isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    public int indexOf(int data){ int index = 0;
        var current = first ;
        while (current != null) {
            if(current.data == data) return index;
            current = current.next;
            index++;
        }
        return -1; // if we don't find the item here.
    }
    public boolean contains(int data){
        return indexOf(data) != -1;
    }
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }
    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last){
            first = last = null ;
            return;
        }
        var previous = getPrevious(last) ;
        last = previous ;
        last.next = null;
        size--;
    }
    private Node getPrevious(Node node){
        var current = first ;
        while(current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }
    public int getSize(){
        return size;
    }
    public int[] toArray(){
        int index = 0 ;
        var array = new int[size] ;
        var current = first ;
        while(current != null){
            array[index++] = current.data ;
            current = current.next ;
        }
        return array ;
    }

//    LEET-CODE PROBLEMS HERE =>
// EASY :
    public Node mergeTwoLists(Node list1, Node list2) {
    var dummyHead = new Node(-1);
    var current = dummyHead ;
    while (list1 != null || list2 != null){
        if(list1 == null) {
            current.next = list2;
            break;
        }
        else if(list2 == null){
            current.next = list1 ;
            break;
        }
        // no null yet
        if(list1.data >= list2.data){
            current.next = list1;
            list1 = list1.next ;
            if (list1 != null)
                current = list1;
        }
        else{
            current.next = list2;
            list2 = list2.next ;
            if(list2 != null)
                current = list2;
        }
    }
    return dummyHead.next;
}

}
