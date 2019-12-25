import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class Deque<Item> implements Iterable<Item> {
    private Node head = null;
    private Node end = null;
    private int n;
    // construct an empty deque
    public Deque() {
        head = null;
        end = null;
        n = 0;
    }

    // unit testing (required)
    public static void main(String[] args) {
        // Something is here
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null || item.equals(""))
            throw new IllegalArgumentException();
        Node add =  new Node();
        add.item = item;

        if (isEmpty()) {
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
    public void addLast(Item item) {
        if (item == null || item.equals(""))
            throw new IllegalArgumentException();
        Node add = new Node();
        add.item = item;
        if (isEmpty()) {
            add.prev = null;
            add.next = null;
            head = add;
            end = add;
        }
        else {
            end.prev = add;
            add.prev = null;
            add.next = end;
            end = add;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (n > 1) {
            head = head.prev;
            head.next = null;
        } else if (n == 1) {
            head.prev = null;
            head.next = null;
            head.item = null;
        } else if (n == 0) {
            throw new NoSuchElementException();
        }
        Item item = head.item;
        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {

        if (n > 1) {
            end = end.next;
            end.prev = null;
        } else if (n == 1) {
            end.prev = null;
            end.next = null;
            end.item = null;
        } else if (n == 0) {
            throw new NoSuchElementException();
        }
        Item item = end.item;
        n--;
        return item;
    }

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>
    {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}