class Solution {
    public boolean stoneGame(int[] piles) {
        Map<String, Boolean> map = new HashMap<>();
        return dfs(piles, map, 0, piles.length - 1, 0, 0, true);
    }

    private boolean dfs(int[] piles, Map<String, Boolean> map, int l, int r, int alice_stone, int bob_stone, boolean alice) {
        if (l > r) {
            return alice_stone > bob_stone;
        }

        String key = l + "," + r;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        
        if (alice) {
            map.put(key,dfs(piles, map, l + 1, r, alice_stone + piles[l], bob_stone, false) ||
                     dfs(piles, map, l, r - 1, alice_stone + piles[r], bob_stone, false));
            return map.get(key);
        } else {
            return dfs(piles, map, l + 1, r, alice_stone, bob_stone + piles[l], true) ||
                     dfs(piles, map, l, r - 1, alice_stone, bob_stone + piles[r], true);
        }

        
    }
}
