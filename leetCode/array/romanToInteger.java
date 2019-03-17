class Solution {
    public int romanToInt(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        stack.push(map.get(s.charAt(0)));
        for (int i=1; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
           if (!stack.isEmpty()) {
               int top = stack.peek();
               if (top < curr) {
                   num += (curr - top);
                   stack.pop();
               } else {
                   stack.push(curr);
               }
           } else {
               stack.push(curr);
           }
        }
        
        while (!stack.isEmpty()) {
            int x = stack.pop();
            num += x;
        }
        
        return num;
    }
}