    // 150. Evaluate Reverse Polish Notation
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s : tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(s.equals("/")) {
                int t = stack.pop();
                stack.push(stack.pop() / t);
            } else if(s.equals("-")) {
                int t = stack.pop();
                stack.push(stack.pop() - t);
            } else 
                stack.push(Integer.valueOf(s));
        }
        return stack.peek();
    }