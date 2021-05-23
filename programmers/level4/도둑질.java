/*
 * 2021.05.23
 * gowoon-choi/github.com
 * programmers 도둑질
 */

package com.gowoon;

public class Solution {
    public int solution(int[] money) {
        int[][] dp = {{money[0], 0}, {0,0}};
        int temp;
        for(int i=1; i<money.length; i++){
            for(int j=0; j<2; j++){
                temp = dp[j][0];
                dp[j][0] = dp[j][1] + money[i];
                dp[j][1] = Math.max(temp, dp[j][1]);
            }
        }
        return Math.max(dp[0][1], Math.max(dp[1][0], dp[0][1]));
    }
}
