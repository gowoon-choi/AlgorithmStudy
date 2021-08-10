import java.io.*;
import java.util.*;

public class Main {
    static class Solution{
        private static int MAX = 1000000;
        private static int MOD = 1000000009;
        private long[] results;
        
        Solution(){
            results = new long[MAX+1];
            Arrays.fill(results, -1);
            results[1] = 1;
            results[2] = 2;
            results[3] = 4;
        }
        
        void init(){
            for(int i=4; i<=MAX; i++){
                results[i] = (results[i-1]+results[i-2]+results[i-3])%MOD;
            }
        }

        long solution(int n){
            return results[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer

        int n = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        solution.init();
        for(int i=0; i<n; i++){
            bw.write(solution.solution(Integer.parseInt(br.readLine())) + "\n");
        }

        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
