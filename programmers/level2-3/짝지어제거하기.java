import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char current;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            current = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == current) stack.pop();
            else stack.push(current);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
