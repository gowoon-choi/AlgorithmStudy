import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int bfs(int[][] graph, int[][]dp){
        int m = graph.length-1;
        int n = graph[0].length-1;
        int[] current;
        int nextX, nextY, curX, curY;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return graph[o2[0]][o2[1]] - graph[o1[0]][o1[1]];
            }
        });
        queue.add(new int[]{0, 0});
        dp[0][0] = 1;
        while(!queue.isEmpty()){
            current = queue.poll();
            curX = current[0];
            curY = current[1];
            for(int k=0; k<4; k++){
                nextX = curX+dx[k];
                nextY = curY+dy[k];
                if(nextX < 0 || nextX > m || nextY < 0 || nextY > n) continue;
                if(graph[nextX][nextY] < graph[curX][curY]){
                    if(dp[nextX][nextY] == 0) queue.add(new int[]{nextX, nextY});
                    dp[nextX][nextY] += dp[curX][curY];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[m][n];
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }
        bw.write(bfs(graph, dp) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
