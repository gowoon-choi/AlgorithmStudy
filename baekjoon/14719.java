import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[w];
        for(int i=0; i<w; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int last = w-1;
        int left = heights[0];
        int right = heights[w-1];
        int[] lefts = new int[w];
        int[] rights = new int[w];
        for(int i=1; i<last; i++){
            if(left <= heights[i]) left = heights[i];
            if(right <= heights[last-i]) right = heights[last-i];
            lefts[i] = left;
            rights[last-i] = right;
        }

        int min;
        int sum = 0;
        for(int i=1; i<last; i++){
            min = Math.min(lefts[i], rights[i]);
            sum += (min - heights[i]);
        }
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
