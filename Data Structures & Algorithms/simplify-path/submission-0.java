class Solution {
    // obj:
    //     simplify the string
    //     1. single . can be ignored, double .. cannot be ignored, other are treated as a folder,
    //      all '.' need to go
    //     2. '/' must be reduced to one, and start with a '/'

    // impl:
    //     1. ..怎么退
    //     2.如何块状识别： 靠‘/’来分割

    public String simplifyPath(String path) {
        //split
        String[] elements = path.split("/");
        Stack<String> res = new Stack<>();
        for (String s: elements){
            if (s.equals("..")){
                if (!res.isEmpty()){
                    res.pop();
                }
            } else if (!s.equals(".") && !s.equals("")){
                res.push(s);
            }
        }
        return "/" + String.join("/" , res);

    }
}