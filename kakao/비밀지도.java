import java.util.Arrays;
class Solution {
    static char[][] board;
    public static void convertBinary(int row, int col, int num){
        while(num > 0){
            if(num%2 == 1) board[row][col] = '#';
            num/=2;
            col--;
        }
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        board = new char[n][n];
        char[] temp;
        for(int i=0; i<n; i++){
            temp = new char[n];
            Arrays.fill(temp, ' ');
            board[i] = temp;
            convertBinary(i, n-1, arr1[i]);
            convertBinary(i, n-1, arr2[i]);
            answer[i] = new String(board[i]);
        }
        return answer;
    }
}
