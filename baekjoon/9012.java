import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            char cur;
            boolean flag = true;
            for(int j=0; j<input.length(); j++){
                cur = input.charAt(j);
                if(cur == '('){
                    stack.add(cur);
                }else{
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()) bw.write("YES");
            else bw.write("NO");
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
