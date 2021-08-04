import java.io.*;
import java.util.*;

public class Main {

    static class Solution{
        private int[] thresholds;
        private int left, right, mid;
        Solution(int[] thresholds){
            this.thresholds = thresholds;
        }

        int solution(int power){
            left = 0;
            right = thresholds.length-1;
            mid = right;
            while(right-left > 1){
                mid = (right+left)/2;
                if(thresholds[mid] >= power) right = mid;
                else left = mid;
            }
            if(thresholds[left] == thresholds[right]) return left;
            return right;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] names = new String[n+1];
        int[] thresholds = new int[n+1];
        thresholds[0] = -1;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            thresholds[i] = Integer.parseInt(st.nextToken());
        }
        Solution solution = new Solution(thresholds);
        for(int i=0; i<m; i++){
            bw.write(names[solution.solution(Integer.parseInt(br.readLine()))] + "\n");
        }

        //bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
