import java.util.*;

public class Programmers {
    public static int bfs(int start, int ignore, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        int cur;
        while (!queue.isEmpty()){
            count++;
            cur = queue.poll();
            visited[cur] = true;
            for(int elem : graph.get(cur)){
                if(elem == ignore || visited[elem]) continue;
                queue.add(elem);
            }
        }
        return Math.abs((graph.size()-1-count)-count);
    }

    public int solution(int n, int[][] wires) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        int min = n;
        for(int[] wire : wires){
            min = Math.min(min, bfs(wire[0],wire[1],graph));
        }
        return min;
    }
}
