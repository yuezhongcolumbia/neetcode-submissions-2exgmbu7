class TimeMap {
    private Map<String, List<Pair<String, Integer>>>map;
    public TimeMap() {
         map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.keySet().contains(key)){
            List<Pair<String,Integer>>list = new ArrayList<>();
            Pair<String,Integer>pair = new Pair(value,timestamp);
            list.add(pair);
            map.put(key,list);
        }else{
            map.get(key).add(new Pair(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>>list = map.getOrDefault(key,new ArrayList<>());
        int size = list.size();
        int l = 0;
        int r = list.size()-1;
        String res="";
        
        while(l<=r){
            int m = (l+r)/2;
            
            
            if(timestamp>=list.get(m).getValue()){
                res = list.get(m).getKey();
                l=m+1;
            }else{
                r=m-1;
            }
        }
        
        return res;
    }
    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return this.value;
        }
    }
}
