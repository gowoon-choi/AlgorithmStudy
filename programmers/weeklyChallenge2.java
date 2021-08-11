import java.util.Arrays;

class Solution {
    static int size;

    public static int[][] transpose(int[][] scores){
        int[][] result = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                result[i][j] = scores[j][i];
            }
        }
        return result;
    }

    public static String getGrade(double score){
        String result;
        if(score >= 90) result = "A";
        else if(score >= 80) result = "B";
        else if(score >= 70) result = "C";
        else if(score >= 50) result = "D";
        else result = "F";
        return result;
    }

    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        size = scores.length;
        scores = transpose(scores);
        int myScore, sum, mean;
        for(int i=0; i<size; i++){
            myScore = scores[i][i];
            Arrays.sort(scores[i]);
            sum = 0;
            for(int j=0; j<size; j++) sum+= scores[i][j];
            if((myScore == scores[i][0] && scores[i][0] != scores[i][1]) || (myScore == scores[i][size-1] && scores[i][size-1] != scores[i][size-2])){
                mean = (sum-myScore)/(size-1);
            }
            else mean = sum/size;
            answer.append(getGrade(mean));
        }
        return answer.toString();
    }
}
