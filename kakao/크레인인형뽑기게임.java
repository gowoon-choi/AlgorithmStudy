import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int top[] = new int[board.length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i] != 0){
                    top[i] = j;
                    break;
                }
            }
        }

        Stack<Integer> basket = new Stack<>();
        int current, row, col;
        for (int move : moves) {
            col = move-1;
            row = top[col];
            if (row == board.length) continue;
            current = board[row][col];
            board[row][col] = 0;
            top[col]++;
            if (!basket.isEmpty() && basket.peek() == current) {
                basket.pop();
                answer += 2;
            } else basket.add(current);
        }

        return answer;
    }
}
