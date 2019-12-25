import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int n;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
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
        if (item == null)
            throw new IllegalArgumentException();
        Node add =  new Node();
        add.item = item;
        if (isEmpty()) {
            add.prev = null;
            add.next = null;
            first = add;
            last = add;
        }
        else {
            first.next = add;
            add.prev = first;
            add.next = null;
            first = add;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node add = new Node();
        add.item = item;
        if (isEmpty()) {
            add.prev = null;
            add.next = null;
            first = add;
            last = add;
        }
        else {
            last.prev = add;
            add.prev = null;
            add.next = last;
            last = add;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item = null;
        if (n > 1) {
            item = first.item;
            first = first.prev;
            first.next = null;
        } else if (n == 1) {
            item = first.item;
            first.prev = null;
            first.next = null;
        } else if (n == 0) {
            throw new NoSuchElementException();
        }
        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Item item = null;
        if (n > 1) {
            item = last.item;
            last = last.next;
            last.prev = null;
        } else if (n == 1) {
            item = last.item;
            last.prev = null;
            last.next = null;
        } else if (n == 0) {
            throw new NoSuchElementException("Queue Underflow");
        }

        n--;
        return item;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.prev;
            return item;
        }
    }


}