/*
 * 2021.03.12
 * gowoon-choi/github.com
 * programmers 네트워크
 */

package com.gowoon;

public class Solution {
    private static Boolean[] visited;

    public static void dfs(int start, int[][] computers){
        visited[start] = true;
        for(int i=0; i<computers[start].length; i++){
            if(!visited[i] && computers[start][i] == 1){
                dfs(i, computers);
            }
        }
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new Boolean[n];
        for(int i=0; i<n; i++){ visited[i] = false; }
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
}
