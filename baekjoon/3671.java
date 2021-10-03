import java.io.*;
import java.util.*;

public class Main {
    public static void permutation(String num, char[] out, boolean[] visited, int depth, int r, HashSet<Integer> result){
        if(depth == r){
            StringBuilder str = new StringBuilder();
            for(char ch : out){
                str.append(ch);
            }
            result.add(Integer.parseInt(str.toString()));
            return;
        }
        for(int i=0; i<num.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = num.charAt(i);
                permutation(num, out, visited, depth+1, r, result);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String num;
        int count;
        HashSet<Integer> targets = new HashSet<>();
        for(int i=0; i<n; i++){
            targets.clear();
            num = br.readLine();
            count = 0;
            for(int j=1; j<=num.length(); j++) permutation(num, new char[j], new boolean[num.length()], 0, j, targets);
            for(Integer target : targets) if(isPrime(target)) count++;
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
