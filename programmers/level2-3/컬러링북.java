import java.util.*;
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int bfs(int[] start, int[][] picture, int m, int n){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int color = picture[start[0]][start[1]];
        picture[start[0]][start[1]] = 0;
        queue.add(start);
        int[] current;
        int x, y;
        while(!queue.isEmpty()){
            current = queue.poll();
            count++;
            for(int i=0; i<4; i++){
                x = current[0]+dx[i];
                y = current[1]+dy[i];
                if(x<0 || x>=m || y<0 || y>=n) continue;
                if(picture[x][y]==color){
                    picture[x][y] = 0;
                    queue.add(new int[]{x, y});
                } 
            }
        }
        return count;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        // copy picture array to preserve original array 
        int [][]pic = new int[m][n];
        for (int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[x].length; y++) {
                pic[x][y] = picture[x][y];
            }
        }
        ArrayList<Integer> areas = new ArrayList<>();
        for(int i=0; i<pic.length; i++){
            for(int j=0; j<pic[i].length; j++){
                if(pic[i][j] == 0) continue;
                areas.add(bfs(new int[]{i, j}, pic, m, n));
            }
        }
        Collections.sort(areas);
        return new int[]{areas.size(), areas.get(areas.size()-1)};
    }
}
