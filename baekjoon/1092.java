import java.io.*;
import java.util.*;

public class Main {
    static class Solution{
        ArrayList<Integer> limits;
        ArrayList<Integer> weights;
        Solution(ArrayList<Integer> limits, ArrayList<Integer> weights){
            this.limits = limits;
            this.weights = weights;
        }
        int solution(){
            int result = 0;
            int index;
            limits.sort(Collections.reverseOrder());
            weights.sort(Comparator.reverseOrder());
            if(limits.get(0) < weights.get(0)) return -1;
            while(!weights.isEmpty()){
                index = 0;
                for(int i=0; i<limits.size(); i++){
                    if(index >= weights.size()) break;
                    if(limits.get(i) >= weights.get(index)) weights.remove(index);
                    else{
                        index++;
                        i--;
                    }
                }
                result++;
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> limits = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            limits.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> weights = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            weights.add(Integer.parseInt(st.nextToken()));
        }
        Solution solution = new Solution(limits, weights);
        bw.write(String.valueOf(solution.solution()));

        bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
