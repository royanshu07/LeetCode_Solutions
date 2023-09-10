class LFUCache {
    public Map<Integer, Pair<Integer, Integer>> dataMap = new HashMap<>();
    public Map<Integer, LinkedHashSet<Integer>> useMap = new HashMap<>();
    int minUse = 1;
    int capacity = 0;

    public LFUCache (int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!dataMap.containsKey(key)) {
            return -1;
        }

        Pair<Integer, Integer> data = dataMap.get(key);
        int use = data.getKey();
        int value = data.getValue();
        increaseUse(key, use, value);
        return value;
    }

    public void put(int key, int value) {
        if (!dataMap.containsKey(key)) {
            if (dataMap.size() >= capacity) {
                int oldKey = useMap.get(minUse).iterator().next();
                dataMap.remove(oldKey);
                useMap.get(minUse).remove(oldKey);
            }
            dataMap.put(key, new Pair<Integer, Integer>(1, value));
            useMap.putIfAbsent(1, new LinkedHashSet<Integer>());
            useMap.get(1).add(key);
            minUse = 1;
            return;
        } 

        Pair<Integer, Integer> data = dataMap.get(key);
        int use = data.getKey();
        increaseUse(key, use, value);  // also update value
    }

    public void increaseUse(int key, int use, int value) {
        dataMap.put(key, new Pair<Integer, Integer>(use + 1, value));
        useMap.get(use).remove(key);
        useMap.putIfAbsent(use + 1, new LinkedHashSet<Integer>());
        useMap.get(use + 1).add(key);
        if (useMap.get(use).size() == 0 && minUse == use) {
            minUse = use + 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */