class Solution {
    Set<String> operators;
    public int evalRPN(String[] tokens) {
        List<String> tokensList = new ArrayList<>();
        for (String token : tokens){
            tokensList.add(token);
        }
        operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        return dfs(tokensList);
    }
    public int dfs(List<String> tokensList){
        //base condition
        String token = tokensList.remove(tokensList.size() - 1);
        if (!operators.contains(token)){
            return Integer.valueOf(token);
        }
        //tree evaluation, what is left, what is right, what is return
        
        int right = dfs(tokensList);
        int left = dfs(tokensList);
        if (token.equals("+")){
            return left + right;
        } else if (token.equals("-")){
            return left - right;
        }else if (token.equals("*")){
            return left * right;
        }else if (token.equals("/")){
            return left / right;
        }
        return 0;

    }
}
