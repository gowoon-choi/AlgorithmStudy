import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static class Way{
        private boolean top;
        private boolean right;
        Way(){
            top = false;
            right = false;
        }
        public void buildTop(){
            top = true;
        }
        public void deleteTop(){
            top = false;
        }
        public void buildRight(){
            right = true;
        }
        public void deleteRight(){
            right = false;
        }
    }

    public static boolean isPossibleTop(Way[][] map, int x, int y){
        if(y==0) return true;
        if(x>0 && map[x-1][y].right) return true;
        if(map[x][y].right) return true;
        if(map[x][y-1].top) return true;
        return false;
    }

    public static boolean isPossibleRight(Way[][] map, int x, int y){
        if(y>0 && map[x][y-1].top) return true;
        if(y>0 && map[x+1][y-1].top) return true;
        if((x>0 && map[x-1][y].right) && (x<map.length-1 && map[x+1][y].right)) return true;
        return false;
    }

    public static boolean checkAll(Way[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j].top && !isPossibleTop(map, i, j)) return false;
                if(map[i][j].right && !isPossibleRight(map, i, j)) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        Way[][] map = new Way[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                map[i][j] = new Way();
            }
        }

        for(int[] frame : build_frame){
            if(frame[3] == 0) {
                if(frame[2] == 0){
                    map[frame[0]][frame[1]].deleteTop();
                    if(!checkAll(map)) map[frame[0]][frame[1]].buildTop();
                }
                else{
                    map[frame[0]][frame[1]].deleteRight();
                    if(!checkAll(map)) map[frame[0]][frame[1]].buildRight();
                }
            }
            else {
                if(frame[2] == 0){
                    if(isPossibleTop(map, frame[0], frame[1])) map[frame[0]][frame[1]].buildTop();
                }
                else{
                    if(isPossibleRight(map, frame[0], frame[1])) map[frame[0]][frame[1]].buildRight();
                }
            }
        }

        ArrayList<int[]> answer = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(map[i][j].top) answer.add(new int[]{i, j, 0});
                if(map[i][j].right) answer.add(new int[]{i, j, 1});
            }
        }
        answer.sort((o1, o2) -> {
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]) return o1[2]-o2[2];
                else return o1[1]-o2[1];
            }
            else return o1[0] - o2[0];
        });
        return answer.toArray(new int[answer.size()][3]);
    }
}
