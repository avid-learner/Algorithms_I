import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private int capacity;
    private int currentSample;
    private Object[] store;

    private final int startingCapacity = 20;

    public class RQueueIterator<Item> implements java.util.Iterator<Item> {
        private Object[] items;
        private int currentNo;
        private int size;
        public RQueueIterator(Object[] store, int sz) {
            items = store;
            size = sz;
            currentNo = 0;
        }

        public boolean hasNext() {
            return currentNo < size;
        }

        public Item next() {
            if (currentNo == size) {
                throw new java.util.NoSuchElementException();
            }
            Item result = (Item)(items[currentNo]);
            items[currentNo] = null;
            currentNo++;
            return result;
        }
    }

    public RandomizedQueue() {
        capacity = startingCapacity;
        store = new Object[capacity];
        size = 0;
        currentSample = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int randomPlace = StdRandom.uniform(0, this.size + 1);
        Object tmp = store[randomPlace];
        store[randomPlace] = item;
        if (randomPlace != size) {
            store[size] = tmp;
        }
        size++;
        checkCapacity();
    }

    public Item dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item result = (Item)(store[size-1]);
        store[size-1] = null;
        size--;
        checkCapacity();
        return result;
    }

    public Item sample() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        Item result = (Item)(store[currentSample]);
        currentSample = (currentSample+1) % size;
        return result;
    }

    public RQueueIterator<Item> iterator() {
        Object[] shuffledItems = new Object[size];
        System.arraycopy(store, 0, shuffledItems, 0, size);
        StdRandom.shuffle(shuffledItems);
        return new RQueueIterator<Item>(shuffledItems, size);
    }

    private void checkCapacity() {
        if (capacity == size) {
            grow();
        } else if (size <= capacity / 4) {
            shrink();
        }
    }

    private void copyStore(Object[] newStore) {
        for (int i = 0; i < this.size; i++) {
            newStore[i] = store[i];
        }
        this.store = newStore;
    }

    private void grow() {
        Object[] newStore = new Object[this.capacity*2];
        this.capacity *= 2;
        copyStore(newStore);
    }

    private void shrink() {
        Object[] newStore = new Object[this.capacity/2];
        this.capacity /= 2;
        copyStore(newStore);
    }

}
