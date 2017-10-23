    // 394. Decode String

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        Stack<StringBuilder> stack = new Stack();
        Stack<Integer> intStack = new Stack();
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (Character.isDigit(c)) number = number * 10 + (c - '0');
            else if(c == '[') {
                intStack.push(number);
                number = 0;
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int times = intStack.pop();
                String dup = sb.toString();
                for (int i = 1; i < times; i++)
                    sb.append(dup);
                sb = stack.pop().append(sb);
            } else sb.append(c);
        }
        return sb.toString();
    }
    