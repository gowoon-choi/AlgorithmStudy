mport java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] subDistances = new int[rocks.length+1];
        subDistances[0]=rocks[0];
        subDistances[rocks.length]=distance-rocks[rocks.length-1];
        for(int i=1; i<rocks.length; i++) subDistances[i] = rocks[i]-rocks[i-1];
        int left = 1;
        int right = distance;
        int mid = (left+right)/2;
        int current, removed;
        while(right-left > 1){
            removed = 0;
            current = 0;
            for(int i=0; i< subDistances.length; i++){
                current += subDistances[i];
                if(current < mid) removed++;
                else current = 0;
            }
            if(removed > n) right = mid;
            else left = mid;
            mid = (left+right)/2;
        }
        return mid;
    }
}
