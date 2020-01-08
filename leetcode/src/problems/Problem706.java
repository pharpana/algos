package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem706<U, V> {

    static class Pair<U, V> {
        U key;
        V value;

        Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }

        void setValue(V Value) {
            this.value = value;
        }
    }

    static class Bucket<U, V> {
        List<Pair<U, V>> bucket;

        Bucket() {
            bucket = new LinkedList<>();
        }

        public V get(U key) {
            return bucket.parallelStream()
                    .filter(pair -> key.equals(pair.key))
                    .map(p -> p.value)
                    .findAny()
                    .orElse(null);
        }

        public void update(U key, V value) {
            boolean found = false;
            for (Pair p : bucket) {
                if (p.key.equals(key)) {
                    p.value = value;
                }
                found = true;
            }
            if (!found) bucket.add(new Pair(key, value));
        }

        public void remove(U key) {
            bucket.parallelStream()
                    .filter(p -> key.equals(p.key))
                    .forEach(p -> bucket.remove(p));
        }
    }

    int keySpace;
    List<Bucket<U, V>> buckets;

    Problem706() {
        keySpace = 2069;
        buckets = new ArrayList<>();
        for (int i = 0; i < keySpace; i++) {
            buckets.add(new Bucket());
        }
    }

    public void put(U key, V value) {
        int index = key.hashCode()%keySpace;
        buckets.get(index).update(key,value);
    }

    public V get(U key){
        return this.buckets.get(key.hashCode()%keySpace).get(key);
    }

    public void remove(U key) {
        this.buckets.get(key.hashCode()%keySpace).remove(key);
    }

    public static void main(String[] args){
        Problem706<Integer, String> hashMap = new Problem706<>();
        hashMap.put(10, "10Value");
        hashMap.put(20, "20Value");
        hashMap.put(30, "30Value");
        hashMap.put(40, "40Value");

        System.out.println(hashMap.get(10));
        System.out.println(hashMap.get(20));
        System.out.println(hashMap.get(30));
        System.out.println(hashMap.get(40));
    }
}
