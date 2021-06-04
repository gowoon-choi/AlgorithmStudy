import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int m;
    public static int n;
    public static int[][] graph;
    public static int[][] dp;

    public static int dfs(int x, int y){
        if(x==m && y==n) return 1;
        if(dp[x][y]!=-1) return dp[x][y];
        dp[x][y] = 0;
        int nextX, nextY;
        for(int i=0; i<4; i++){
            nextX = x+dx[i];
            nextY = y+dy[i];
            if(nextX < 0 || nextX > m || nextY < 0 || nextY > n) continue;
            if(graph[nextX][nextY] < graph[x][y]){
                dp[x][y] += dfs(nextX, nextY);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        m--; n--;
        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
