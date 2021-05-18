/*
 * 2021.05.18
 * gowoon-choi/github.com
 * programmers 단속카메라
 */

package com.gowoon;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int flag = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][0] <= flag){
                if(flag < routes[i][1]) continue;
            }
            else answer++;
            flag = routes[i][1];
        }
        return answer;
    }
}
