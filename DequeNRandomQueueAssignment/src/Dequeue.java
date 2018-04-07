import java.util.NoSuchElementException;

public class Dequeue<Item> implements Iterable<Item>{

    private class Node<Item> {
        private Item value;
        private Node<Item> next, prev;

        public Node(Item newValue, Node<Item> newNext, Node<Item> newPrev)
        {
            value = newValue;
            next = newNext;
            prev = newPrev;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return this.value;
        }

        public void setNext(Node<Item> n) {
            this.next = n;
        }

        public Node<Item> getNext() {
            return this.next;
        }

        public void setPrev(Node<Item> n) {
            this.prev = n;
        }

        public Node<Item> getPrev() {
            return this.prev;
        }

    }

    public class DequeIterator implements java.util.Iterator<Item>
    {
        private Node<Item> currentNode;
        DequeIterator(Node<Item> n) {
            currentNode = n;
        }

        public boolean hasNext() {
            return (currentNode != null);
        }

        public Item next() {
            if (currentNode == null) {
                throw new java.util.NoSuchElementException();
            }
            Item result = currentNode.getValue();
            currentNode = currentNode.getNext();
            return result;
        }
    }

    public DequeIterator iterator() {
        return new DequeIterator(this.head);
    }

    private int size;

    private Node<Item> head, tail, beforeTail;
    public Dequeue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new java.lang.IllegalArgumentException();
        Node<Item> newNode = new Node<Item>(item, this.head, null);
        if (this.tail == null) {
            this.tail = newNode;
        } else {
            this.head.setPrev(newNode);
        }
        this.head = newNode;
        this.size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new java.lang.IllegalArgumentException();
        Node<Item> newNode = new Node<Item>(item, null, this.tail);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.size++;
    }

    public Item removeFirst() {
        if (this.head == null) throw new java.util.NoSuchElementException();
        Item resultItem = this.head.getValue();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return resultItem;
    }

    public Item removeLast() {
        if (this.head == null) throw new java.util.NoSuchElementException();
        Item resultItem = this.tail.getValue();
        this.tail = this.tail.getPrev();
        if (this.tail == null) {
            this.head = null;
        }
        this.size--;
        return resultItem;
    }
}
