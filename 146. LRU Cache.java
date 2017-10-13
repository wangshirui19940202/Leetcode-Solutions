// 146. LRU Cache

public class LRUCache {
    
    class ListNode {
        int key, val;
        ListNode pre, next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, ListNode> map;
    ListNode head, tail;
    int size, capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap();
    }
    
    public int get(int key) {
        ListNode cur = map.get(key);
        if (cur == null) return -1;
        else {
            update(cur);
            return cur.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.val = value;
            update(cur);
            return;
        } else {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            ListNode next = head.next;
            head.next = newNode;
            next.pre = newNode;
            newNode.pre = head;
            newNode.next = next;
            size++;
            if (size > capacity) {
                ListNode last = tail.pre;
                map.remove(last.key);
                delete(last);
            }
        }
    }
    
    private void delete(ListNode cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.next = null;
        cur.pre = null;
    }
    private void update(ListNode cur) {
        delete(cur);
        ListNode next = head.next;
        head.next = cur;
        next.pre = cur;
        cur.pre = head;
        cur.next = next;
    }
}