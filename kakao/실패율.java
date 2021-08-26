import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static class Result{
        private int stage;
        private double failRate;
        Result(int stage, double failRate){
            this.stage = stage;
            this.failRate = failRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] curStage = new int[N];
        int total = 0;
        for (int stage : stages) {
            if (stage > N) total++;
            else curStage[stage - 1]++;
        }

        Result[] result = new Result[N];
        for(int i=N-1; i>=0; i--){
            total += curStage[i];
            if(total == 0) result[i] = new Result(i+1, 0);
            else result[i] = new Result(i+1, (double)curStage[i]/total);
        }
        Arrays.sort(result, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if(o1.failRate > o2.failRate) return -1;
                else if(o1.failRate < o2.failRate) return 1;
                return 0;
            }
        });

        for(int i=0; i<N; i++){
            answer[i] = result[i].stage;
        }

        return answer;
    }
}
