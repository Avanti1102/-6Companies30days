class LRUCache {
    int capacity;
    Queue<Integer> q=new ArrayDeque<>();
    Map<Integer,Integer> map=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            q.remove(key);
            q.offer(key);
            return map.get(key);
        } 
        else 
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) 
        {
            q.remove(key);
            q.offer(key);
            map.put(key,value);
        }
        else 
        {
            if(q.size() < capacity)
                q.offer(key);
            else 
            {
                map.remove(q.poll()); 
                q.offer(key);
            }
            map.put(key,value); 
        }
    }
}
