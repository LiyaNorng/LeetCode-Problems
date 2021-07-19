class LRUCache {

    class Node{
        int val;
        int key;
        Node left;
        Node right;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> hash;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        hash = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (hash.containsKey(key)){
            Node temp = hash.get(key);
            if (head.key != temp.key && tail.key != temp.key){
                temp.left.right = temp.right;
                temp.right.left = temp.left;
                temp.right = head;
                head.left = temp;
                head = temp;
            }
            else if (temp.key == tail.key && head.key != temp.key){
                tail = tail.left;
                tail.right = null;
                temp.right = head;
                head.left = temp;
                head = temp;
            }
            
            
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node temp;

        if (hash.containsKey(key)){
            temp = hash.get(key);
            if (head.key != temp.key && tail.key != temp.key){
                temp.left.right = temp.right;
                temp.right.left = temp.left;
                temp.right = head;
                head.left = temp;
                head = temp;
            }
            else if (temp.key == tail.key && head.key != temp.key){
                tail = tail.left;
                tail.right = null;
                temp.right = head;
                head.left = temp;
                head = temp;
            }
            temp.val = value;
        }
        else {

            if (hash.size() == cap){
                Node cur = tail;
                if (tail == head){
                    head = null;
                }
                else{
                    tail = tail.left;
                    tail.right = null;   
                }
                hash.remove(cur.key);
            }
            temp = new Node(key, value);
            hash.put(key, temp);
            if (head == null){
                head = temp;               
                tail = head;
            }
            else{
                temp.right = head;
                head.left = temp;
                head = temp;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */