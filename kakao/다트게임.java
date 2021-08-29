import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public static class Score{
        private double score;
        private char op2 = ' ';

        Score(String score, String op){
            double pow;
            if(op.charAt(0) == 'S') pow = 1;
            else if(op.charAt(0) == 'D') pow = 2;
            else pow = 3;
            this.score = Math.pow(Double.parseDouble(score), pow);
            if(op.length() > 1) op2 = op.charAt(1);
        }

        public void makeDouble(){
            this.score *= 2;
        }

        public void makeMinus(){
            this.score *= -1;
        }
    }
    
    public int solution(String dartResult) {
        int answer = 0;

        Pattern patternScore = Pattern.compile("[0-9]{1,2}");
        Pattern patternOp = Pattern.compile("[SDT][*#]?");
        Matcher matcherScore = patternScore.matcher(dartResult);
        Matcher matcherOp = patternOp.matcher(dartResult);
        Stack<Score> scores = new Stack<>();
        while(matcherScore.find() && matcherOp.find()){
            scores.push(new Score(matcherScore.group(), matcherOp.group()));
        }

        Score current;
        while(!scores.isEmpty()){
            current = scores.pop();
            if(current.op2 == '*'){
                current.makeDouble();
                if(!scores.isEmpty()) scores.peek().makeDouble();
            }
            else if(current.op2 == '#') current.makeMinus();
            answer += current.score;
        }

        return answer;
    }
}
