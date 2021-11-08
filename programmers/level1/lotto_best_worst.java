class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        boolean[] checked = new boolean[46];
        for(int num : win_nums){ checked[num] = true; }
        int correct = 0;
        int possible = 0;
        for(int num : lottos){
            if(num == 0) possible++;
            else if(checked[num]) correct++;
        }
        answer[0] = Math.min(6, 7-(correct+possible));
        answer[1] = Math.min(6, 7-correct);
        
        return answer;
    }
}
