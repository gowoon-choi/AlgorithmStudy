/*
 * 2021.05.07
 * gowoon-choi/github.com
 * programmers H-Index
 */

package com.gowoon;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int temp;
        for(int i=0; i<citations.length; i++){
            if((citations.length-i) < citations[i]){
                try{ temp = citations[i-1]; }catch (Exception e){ temp = 0; }
                answer = Math.max((citations.length-i), temp);
                break;
            }
        }
        return answer;
    }
}
