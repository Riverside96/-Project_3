package graphalgos;
public class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int capacity;
    private int size;
    private Entry<K, V>[] bucket;


 private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.bucket = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = bucket[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        bucket[index] = new Entry<>(key, value, bucket[index]);
        size++;
        if (size > capacity * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = bucket[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Entry<K, V> entry = bucket[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = bucket[index];
        if (entry == null) {
            return;
        }
        if (entry.key.equals(key)) {
            bucket[index] = entry.next;
            size--;
            return;
        }
        while (entry.next != null) {
            if (entry.next.key.equals(key)) {
                entry.next = entry.next.next;
                size--;
                return;
            }
            entry = entry.next;
        }
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity *= 2;
        Entry<K, V>[] oldBucket = bucket;
        bucket = new Entry[capacity];
        size = 0;
        for (Entry<K, V> entry : oldBucket) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

}
