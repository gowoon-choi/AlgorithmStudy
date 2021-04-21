/*
 * 2021.04.20
 * gowoon-choi/github.com
 * programmers 순위
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int in = 0;
    private static final int out = 1;

    public static class Node{
        private ArrayList<ArrayList<Integer>> list;
        Node(){
            this.list = new ArrayList<>();
            for(int i=0; i<2; i++){
                list.add(new ArrayList<>());
            }
        }
    }

    public static int countNode(int node, ArrayList<Node> graph, boolean[] visited, int inOrOut){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;
            for(int i=0; i<graph.get(current).list.get(inOrOut).size(); i++){
                if(!visited[graph.get(current).list.get(inOrOut).get(i)]){
                    queue.add(graph.get(current).list.get(inOrOut).get(i));
                }
            }
        }
        for(int i=1; i< visited.length; i++){
            if(visited[i]){
                visited[i] = false;
                count++;
            }
        }
        return count-1;
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Node> graph = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new Node());
            visited[i] = false;
        }
        for(int[] result : results){
            graph.get(result[0]).list.get(out).add(result[1]);
            graph.get(result[1]).list.get(in).add(result[0]);
        }
        int inNode, outNode;
        for(int i=1; i<=n; i++){
            inNode = countNode(i, graph, visited, in);
            outNode = countNode(i, graph, visited, out);
            if(inNode + outNode == n-1) answer++;
        }
        return answer;
    }
}
