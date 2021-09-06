import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public static class Way{
        private boolean right;
        private boolean top;
        Way(){
            this.right = false;
            this.top = false;
        }
        public void right(){
            this.right = !this.right;
        }
        public void top(){
            this.top = !this.top;
        }
    }

    public static boolean isPossible(Way[][] board, int x, int y, int object) {
        if(object == 0){
            if(x == 0) return true;
            if((y!=0 && board[x][y-1].right) || board[x][y].right) return true;
            if(board[x-1][y].top) return true;
        }
        else{
            if(board[x-1][y].top || board[x-1][y+1].top) return true;
            if(board[x][y-1].right && board[x][y].right) return true;
        }
        return false;
    }

    public static void operator(Way[][] board, int x, int y, int object){
        if(object == 0){
            board[x][y].top();
            if(!isPossible(board, x, y, object)) board[x][y].top();
        }
        else{
            board[x][y].right();
            if(!isPossible(board, x, y, object)) board[x][y].right();
        }
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        Way[][] board = new Way[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                board[i][j] = new Way();
            }
        }
        for(int[] frame : build_frame){
            operator(board, frame[1], frame[0], frame[2]);
        }
        ArrayList<int[]> answerList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(board[i][j].top) answerList.add(new int[]{j, i, 0});
                if(board[i][j].right) answerList.add(new int[]{j, i, 1});
            }
        }
        answerList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]) return o1[2]-o2[2];
                    else return o1[1]-o2[1];
                }
                else return o1[0] - o2[0];
            }
        });
        return answerList.toArray(new int[answerList.size()][3]);
    }
}
