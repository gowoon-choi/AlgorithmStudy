import java.io.*;
import java.util.*;

public class Main {
    private static Queue<int[]> queue = new LinkedList<>();
    private static boolean[][] genVisited = new boolean[1500][1500];

    public static void combination(int[] input, int start, int depth, int r, int[] output, boolean[] visited){
        if(depth == r){
            int min = Math.min(output[0], output[1]);
            int max = Math.max(output[0], output[1]);
            int other = 0;
            for(int i=0; i< visited.length; i++){
                if(!visited[i]) other = input[i];
            }
            max = max-min;
            min = min*2;
            int[] temp = {min, max, other};
            Arrays.sort(temp);
            if(!genVisited[temp[0]][temp[1]]){
                queue.add(temp);
                genVisited[temp[0]][temp[1]] = true;
            }
            return;
        }
        for(int i=start; i<input.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = input[i];
                combination(input, i+1, depth+1, r, output, visited);
                visited[i] = false;
            }
        }
    }

    public static boolean isAllSame(int[] elem){
        for(int i=1; i< elem.length; i++){
            if(elem[i-1] != elem[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[3];
        int sum = 0;
        for(int i=0; i<3; i++){
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i];
        }

        boolean flag = false;
        if(sum%3 == 0) {
            Arrays.sort(input);
            queue.add(input);
            genVisited[input[0]][input[1]] = true;
            int[] cur;
            while(!queue.isEmpty()){
                cur = queue.poll();
                if(isAllSame(cur)){
                    flag = true;
                    break;
                }
                combination(cur, 0, 0, 2, new int[2], new boolean[3]);
            }
        }
        if(flag) bw.write(1+"\n");
        else bw.write(0+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
