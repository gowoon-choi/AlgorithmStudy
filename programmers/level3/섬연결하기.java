/*
 * 2021.05.01
 * gowoon-choi/github.com
 * programmers 섬 연결하기
 */

package com.gowoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<int[]> cost_arr = new ArrayList<>(Arrays.asList(costs));
        cost_arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        ArrayList<Integer> possible = new ArrayList<>();
        int[] current = cost_arr.get(0);
        possible.add(current[0]);
        possible.add(current[1]);
        answer += current[2];
        int count, new_node = 0;
        while(possible.size() < n){
            for(int i=1; i< cost_arr.size(); i++){
                current = cost_arr.get(i);
                count = 0;
                if(possible.contains(current[0])){
                    count++;
                    new_node = 1;
                }
                if(possible.contains(current[1])){
                    count++;
                    new_node = 0;
                }
                if(count == 0) continue;
                if(count == 1){
                    possible.add(current[new_node]);
                    answer += current[2];
                }
                cost_arr.remove(i);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}));
    }
}
