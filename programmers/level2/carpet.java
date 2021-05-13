/*
 * 2021.05.13
 * gowoon-choi/github.com
 * programmers 카펫
 */

package com.gowoon;

public class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width, height;
        for(int i=1; i<=yellow; i++){
            if(yellow%i != 0) continue;
            height = i;
            width = yellow/height;
            if((width*2+(height+2)*2) == brown){
                answer[0] = width+2;
                answer[1] = height+2;
                break;
            }
        }
        return answer;
    }
}
