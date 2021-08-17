import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 0;
        for(int i=1; i<=n; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        // init dp
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + board[i][j] - dp[i-1][j-1];
            }
        }

        int x1, y1, x2, y2, result;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken())-1;
            y1 = Integer.parseInt(st.nextToken())-1;
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            result = dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1];
            bw.write(result+"\n");
        }

        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
