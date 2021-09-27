import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        ArrayList<Integer> bigger = new ArrayList<>();
        ArrayList<Integer> smaller = new ArrayList<>();
        int big, small;
        for(int[] size : sizes){
            big = size[0];
            small = size[1];
            if(size[0] < size[1]){
                small = size[0];
                big = size[1];
            }
            bigger.add(big);
            smaller.add(small);
        }
        big = Collections.max(bigger);
        small = Collections.max(smaller);
        answer = big*small;
        
        return answer;
    }
}
