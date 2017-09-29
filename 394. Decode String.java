    // 394. Decode String
   
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numstack = new Stack();
        Stack<StringBuilder> strstack = new Stack();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) 
                cur = cur * 10 + c - '0';
            else if (c == '[') {
                numstack.push(cur);
                cur = 0;
                strstack.push(sb);
                sb = new StringBuilder();
            } else if(c == ']') {
                String t = sb.toString();
                for(int i = 1; i < numstack.peek(); i++)
                    sb.append(t);
                sb.insert(0, strstack.pop());
                numstack.pop();
            } else 
                sb.append(c);
        }
        return sb.toString();
    }