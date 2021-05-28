/*
 * 2021.05.24
 * gowoon-choi/github.com
 * programmers 여행경로
 */

package com.gowoon;

import java.util.*;

public class Solution {
    public static String[] answer; 
    public static boolean[] visited; 
    public static boolean flag = false;

    public static void dfs(String[][] tickets, int start, int count){
        visited[start] = true; 
        answer[count] = tickets[start][0]; 
        if(count == tickets.length-1){
            answer[count+1] = tickets[start][1];
            flag = true;
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(tickets[start][1]) && !visited[i]){
                dfs(tickets, i, count+1); 
                if(flag) return; 
                visited[i] = false;
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                Arrays.fill(visited, false);
                dfs(tickets, i, 0);
                if(flag) break;
            }
        }
        return answer;
    }
}
