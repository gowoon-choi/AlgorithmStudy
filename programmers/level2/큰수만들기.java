/*
 * 2021.04.01
 * gowoon-choi/github.com
 * programmers 큰 수 만들기
 */

package com.gowoon;

public class Solution {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int max, index;
        while (k > 0){
            if(k >= number.length()){
                number = "";
                break;
            }
            max = 0;
            index = 0;
            for(int i=0; i<=k; i++){
                if((number.charAt(i)-'0') > max){
                    max = number.charAt(i)-'0';
                    index = i;
                }
            }
            answer.append(number.charAt(index));
            number = number.substring(index+1);
            k-=index;
        }
        return answer + number;
    }
}
