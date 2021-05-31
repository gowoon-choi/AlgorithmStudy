import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char current;
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            current = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == current) stack.pop();
            else stack.push(current);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
