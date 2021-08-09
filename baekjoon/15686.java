import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Solution{
        private int m;
        private boolean[] visited;
        private ArrayList<Point> chickens;
        private ArrayList<Point> customers;
        private int result;

        Solution(int m, ArrayList<Point> chickens, ArrayList<Point> customers){
            this.m = m;
            this.chickens = chickens;
            this.customers = customers;
            this.visited = new boolean[chickens.size()];
            this.result = Integer.MAX_VALUE;
        }

        void combination(int current, int count){
            if(count == m){
                Point chicken, customer;
                int chicken_dis;
                int city_dis = 0;
                for(int i=0; i<customers.size(); i++){
                    customer = customers.get(i);
                    chicken_dis = Integer.MAX_VALUE;
                    for(int j=0; j<chickens.size(); j++){
                        if(visited[j]){
                            chicken = chickens.get(j);
                            chicken_dis = Math.min(chicken_dis,
                                    (Math.abs(customer.x-chicken.x)+Math.abs(customer.y-chicken.y)));
                        }
                    }
                    city_dis += chicken_dis;
                }
                result = Math.min(result, city_dis);
                return;
            }
            for(int i=current; i<chickens.size(); i++){
                visited[i] = true;
                combination(i+1, count+1);
                visited[i] = false;
            }
        }

        int solution(){
            combination(0, 0);
            return result;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Point> chickens = new ArrayList<>();
        ArrayList<Point> customers = new ArrayList<>();
        int temp;
        for(int r=0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<n; c++){
                temp = Integer.parseInt(st.nextToken());
                if(temp == 1) customers.add(new Point(r, c));
                else if(temp == 2) chickens.add(new Point(r, c));
            }
        }

        Solution solution = new Solution(m, chickens, customers);
        bw.write(String.valueOf(solution.solution()));

        bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
