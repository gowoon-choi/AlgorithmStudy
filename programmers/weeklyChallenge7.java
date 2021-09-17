import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Arrays.fill(answer, 0);

        int inIndex = 0;
        int outIndex;
        ArrayList<Integer> in = new ArrayList<>();
        for (int target : leave) {
            if (!in.contains(target)) {
                for (int j = inIndex; j < enter.length; j++) {
                    in.add(enter[j]);
                    if (enter[j] == target) {
                        inIndex = j + 1;
                        break;
                    }
                }
            }
            outIndex = in.indexOf(target);
            answer[target - 1] += in.size() - 1;
            in.remove(outIndex);
            for (Integer person : in) {
                answer[person - 1]++;
            }
        }

        return answer;
    }
}
