import java.io.*;
import java.util.*;

public class Main {
    static int[][] distance;
    static Point[] points;
    public static class Point{
        private int x;
        private int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int calculateDistance(int a, int b){
        if(distance[a][b] == -1) {
            int dis = Math.abs(points[a].x-points[b].x) + Math.abs(points[a].y-points[b].y);
            distance[a][b] = dis;
            distance[b][a] = dis;
        }
        return distance[a][b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        points = new Point[n];
        int[][] dp = new int[k+1][n];
        distance = new int[n][n];

        int[] arr;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            arr = new int[n];
            Arrays.fill(arr, -1);
            distance[i] = arr;
        }

        for(int i=0; i<=k; i++) {
            arr = new int[n];
            Arrays.fill(arr, -1);
            dp[i] = arr;
            if(i==0) dp[i][0] = 0;
        }

        int min, temp;
        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                if(i-j > 0){
                    min = Integer.MAX_VALUE;
                    for(int z=0; z<=j; z++){
                        temp = dp[j-z][i-z-1];
                        if(temp == -1) continue;
                        min = Math.min(min, temp+calculateDistance(i-z-1, i));
                    }
                    dp[j][i] = min;
                }
            }
        }

        int result = dp[0][n-1];
        for(int i=1; i<=k; i++){
            if(dp[i][n-1] < result) result = dp[i][n-1];
        }
        bw.write(String.valueOf(result));

        bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
