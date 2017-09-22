    // 224. Basic Calculator

    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int num = 0, sign = 1, result = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(result);
                result = 0;
                stack.push(sign);
                sign = 1;
            } else if(c == ')') {
                result += sign * num;
                result = stack.pop() * result + stack.pop();
                num = 0;
            }
        }
        if(num != 0) result += sign * num;
        return result;
    }