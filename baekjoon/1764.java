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
        String[] list = new String[n+m];
        for(int i=0; i<n+m; i++){
            list[i] = br.readLine();
        }
        Arrays.sort(list);
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<list.length-1; i++){
            if(list[i].equals(list[i+1])){
                result.add(list[i++]);
            }
        }
        bw.write(result.size()+"\n");
        for (String s : result) bw.write(s + "\n");

        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
