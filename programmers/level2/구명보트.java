/*
 * 2021.04.23
 * gowoon-choi/github.com
 * programmers 구명보트
 */

package com.gowoon;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        for(int i=people.length-1 ; i>=left; i--){
            if(people[i]+people[left] <= limit){
                left++;
            }
            answer++;
        }
        return answer;
    }
}
