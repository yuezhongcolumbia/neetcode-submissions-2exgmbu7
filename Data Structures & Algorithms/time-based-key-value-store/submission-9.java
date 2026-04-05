class TimeMap {
    public static class Pair{
        int time;
        String value;
        public Pair(String value, int time){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<Pair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        List<Pair> list = timeMap.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";
        while (l <= r){
            int m = l + (r - l) / 2;
            Pair curr = list.get(m);
            int currTime = curr.time;
            if (currTime == timestamp) return curr.value;
            if (currTime < timestamp){
                res = curr.value;
                l = m + 1;
            } else if (currTime > timestamp) {
                r = m - 1;
            }
        }
        return res;
    }
}
