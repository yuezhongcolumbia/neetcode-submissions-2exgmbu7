class TimeMap {
    HashMap<String, String[]> keyString;
    HashMap<String, List<Integer>> keyTime;
    public TimeMap() {
        // initiate;
        keyString = new HashMap<>();
        keyTime = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // update keyString
        if (!keyString.containsKey(key)){
            keyString.put(key, new String[1001]);
        }
        keyString.get(key)[timestamp] = value;
        // update keyTime
        keyTime.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        // binarySearch with feasiblity function
        // l = 0, r = last 
        if (!keyTime.containsKey(key)) return "";
        List<Integer> timeList = keyTime.get(key);
        int l = 0, r = timeList.size() - 1;
        int res = -1;
        while (l <= r){
            int m = (l + r) / 2;
            int mid = timeList.get(m);
            if (mid <= timestamp) {
                res = mid;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res != -1 ? keyString.get(key)[res] : "";
    }
}
