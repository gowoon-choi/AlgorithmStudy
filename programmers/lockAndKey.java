import java.util.Arrays;
class Solution {
    public static int[][] rotation(int[][] matrix){
        int size = matrix.length;
        int[][] result = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                result[j][size-1-i] = matrix[i][j];
            }
        }
        return result;
    }

    public static boolean isPossible(int[][] key, int[][] lock){
        int m = key.length;
        int n = lock.length;
        int board_size = n + (2*(m-1));
        int[][] board = new int[board_size][board_size];
        int[] arr;

        // key 이동
        int temp;
        boolean index;
        for(int i=0; i<(m-1)+n; i++){
            for(int j=0; j<(m-1)+n; j++){
                index = true;
                // init board
                for(int k=0; k<board_size; k++){
                    arr = new int[board_size];
                    Arrays.fill(arr, -1);
                    board[k] = arr;
                }
                for(int k=0; k<lock.length; k++){
                    for(int l=0; l<lock.length; l++){
                        board[k+m-1][l+m-1] = lock[k][l];
                    }
                }
                // key 이동
                for(int k=0; k<key.length; k++){
                    for(int l=0; l<key.length; l++){
                         // 겹치는 부분 반영
                        if(board[i+k][j+l]!=-1){
                            board[i+k][j+l] += key[k][l];
                        }
                    }
                }
                // lock 검사
                for(int k=0; k<lock.length; k++){
                    for(int l=0; l<lock.length; l++){
                        temp = board[k+m-1][l+m-1];
                        if(temp != 1){
                            index = false;
                            break;
                        }
                    }
                    if(!index) break;
                }
                // 검사 결과 확인
                if(index) return true;
            }
        }
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        for(int i=0; i<4; i++){
            if(i!=0) key = rotation(key);
            if(isPossible(key, lock)) return true;
        }
        return false;
    }
}
