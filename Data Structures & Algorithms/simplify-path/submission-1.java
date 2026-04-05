class Solution {
    // obj:
    //     1.'/'
    //         open with '/'
    //         '///' are treated as one
    //     2. '.'
    //         one means current
    //         two means previous
    //         other means a valid file
    //     3. we need elimnate:
    //         1. multiple "/"
    //         2. one and two dot
    // impl:
    //     1.split
    //     2.multple '/' : ignore ""
    //     3.one dot: ignore
    //     4.two dot: pop previous
    // variants:
    //     1. stack
    //     2. res
    //     3. path
    // transition:
    //     1. stack:
    //         push everything other than: "",".",".."
    //         pop: ".."
    //     2.res:
    //         last step, start with /, String.join("/",stack)
    //     3.path:
    //         split into String[]

    public String simplifyPath(String path) {
        //initiate
        Stack<String> stack = new Stack<>();
        String[] pathArr = path.split("/");
        for (String s: pathArr){
            if (!stack.isEmpty() && s.equals("..")){
                stack.pop();
            } else if (!s.equals ("") && !s.equals(".") && !s.equals("..")){
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}