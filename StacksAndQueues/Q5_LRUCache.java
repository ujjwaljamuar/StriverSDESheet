import java.util.HashMap;
import java.util.Map;

public class Q5_LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);

    Map<Integer, Node> map = new HashMap<>();

    int capacity;

    Q5_LRUCache(int _capacity) {
        this.capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        map.put(node.key, node);

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    private class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }
}
