import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] tree, height;

    public static int find(int x){
        if(tree[x] == x) return x;
        else return tree[x] = find(tree[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return;
        if(height[x] < height[y]) tree[x] = y;
        else {
            tree[y] = x;
            if(height[x] == height[y]) height[x]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        tree = new int[n];
        height = new int[n];
        for(int i=0; i<n; i++){
            tree[i] = i;
            height[i] = 0;
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                if(st.nextToken().equals("1")){
                    union(i, j);
                }
            }
        }
        int cur, next;
        String result = "YES";
        st = new StringTokenizer(br.readLine());
        cur = Integer.parseInt(st.nextToken())-1;
        for(int i=1; i<m; i++){
            next = Integer.parseInt(st.nextToken())-1;
            if(find(cur) == find(next)){
                cur = next;
            }
            else{
                result = "NO";
                break;
            }
        }
        bw.write(result);
        bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
