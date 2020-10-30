import java.util.LinkedList;
import java.util.Queue;

class Solution {
   public int calDays(int progresses, int speeds){
        int days = (100-progresses)/speeds;
        if((100-progresses)%speeds != 0){ days ++; }
        return days;
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int days = calDays(progresses[0], speeds[0]);
        int count = 1;
        for(int i=1; i<progresses.length; i++){
            if(progresses[i]+(days*speeds[i]) >= 100){
                count ++;
            }
            else{
                q.add(count);
                days = calDays(progresses[i], speeds[i]);
                count = 1;
            }
        }
        q.add(count);
        int[] answer = new int[q.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = q.remove();
        }
        return answer;
    }
}
