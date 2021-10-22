import java.io.*;
import java.util.*;

public class Main {

    public static int convertTo10(int[] arr, int n){
        int result = 0;
        for(int i=0; i<arr.length; i++){
            result += (Math.pow(n, i)*arr[i]);
        }
        return result;
    }

    public static String convertFrom10(int num, int n){
        StringBuilder result  = new StringBuilder();
        while (num!=0){
            result.insert(0, (num % n) +" ");
            num /= n;
        }
        return result.substring(0, result.length()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a  = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[n - i - 1] = Integer.parseInt(st.nextToken());
        }
        bw.write(convertFrom10(convertTo10(arr, a), b));
        bw.flush();
        bw.close();
        br.close();
    }
}
