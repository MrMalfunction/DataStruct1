 import java.util.Iterator;
import java.io.*;
 import java.util.NoSuchElementException;

 public class Deque<Item> implements Iterable<Item> {
    private Node head = null;
    private Node end = null;
    private int n;
    private class Node{
        Item item;
        Node prev;
        Node next;
    }
    // construct an empty deque
    public Deque(){
        head = null;
        end = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return n==0;
    }

    // return the number of items on the deque
    public int size(){
        return n;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null || item == "")
            throw new IllegalArgumentException();
        Node add =  new Node();
        add.item = item;

        if(isEmpty()){
            add.prev = null;
            add.next = null;
            head = add;
            end = add;
        }
        else {
            head.next = add;
            add.prev = head;
            add.next = null;
            head = add;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item == null || item == "")
            throw new IllegalArgumentException();
        Node add = new Node();
        add.item = item;
        if (isEmpty()){
            add.prev = null;
            add.next = null;
            head = add;
            end = add;
        }
        else {
            end.prev = add;
            add.prev=null;
            add.next=end;
            end = add;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        Item item = head.item;
        if(n>1){
            head = head.prev;
            head.next = null;
        }
        else if (n==1){
            head.prev = null;
            head.next = null;
            head.item = null;
        }
        else if(n==0){
            throw new NoSuchElementException();
        }

        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        Item item = end.item;
        if(n>1){
            end = end.next;
            end.prev = null;
        }
        else if (n==1){
            end.prev = null;
            end.next = null;
            end.item = null;
        }
        else if(n==0){
            throw new NoSuchElementException();
        }

        n--;
        return item;
    }

    private class DequeIterator implements Iterator<Item>
    {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
        public Item next()
        {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() { return new DequeIterator(); }

    // unit testing (required)
    /*public static void main(String[] args) throws IOException {
        Deque<String> queue = new Deque<String>();
        queue.addFirst("a");
        queue.addFirst("m");
        queue.addFirst("o");
        queue.addFirst("l");
        queue.addLast("b");
        queue.addLast("o");
        queue.addLast("h");
        queue.addLast("o");
        queue.addLast("r");
        queue.addLast("A");
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeLast());
        FileReader fr = new FileReader("D://randomtext_gibberish_p.txt");
        int i;
        while ((i=fr.read()) != -1)
            queue.addFirst(Character.toString((char)i));
        for(i=0;i<=1000000;i++)
            System.out.print(queue.removeLast());
        queue.iterator();
    }*/

}