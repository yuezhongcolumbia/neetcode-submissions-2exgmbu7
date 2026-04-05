class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> Q = new LinkedList<>();

        for (int i  = 0; i < senate.length(); i++){
            if (senate.charAt(i) == 'R'){
                R.add(i);
            } else {
                Q.add(i);
            }
        }

        while (!R.isEmpty() && !Q.isEmpty()){
            int rIndex = R.poll();
            int qIndex = Q.poll();
            
            if (rIndex < qIndex){
                R.add(rIndex + senate.length());
            } else {
                Q.add(qIndex + senate.length());
            }
        }
        return Q.isEmpty() ? "Radiant" : "Dire";
    }
}