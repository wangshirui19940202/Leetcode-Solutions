    // 388. Longest Absolute File Path
    
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        int res = 0;
        String[] inputs = input.split("\n");
        for(String s : inputs) {
            int space = s.lastIndexOf('\t') + 1 + 1;
            while(stack.size() > space) stack.pop();
            stack.push(stack.peek() + s.length() - space + 1 + 1);
            if(s.indexOf(".") >= 0)
                res = Math.max(res, stack.peek() - 1);
        }
        return res;
    }