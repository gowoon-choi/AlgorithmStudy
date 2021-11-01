import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int w, v;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            for(int j=1; j<=k; j++){
                if(w > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
            }
        }
        bw.write(dp[n][k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
