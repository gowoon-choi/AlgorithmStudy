/*
 * 2021.03.19
 * gowoon-choi/github.com
 * programmers 등굣길
 */

public class Solution {
    private static final int divider = 1000000007;
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for (int[] puddle : puddles) dp[puddle[1]][puddle[0]] = -1;
        dp[0][1] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if (dp[j][i] == -1) dp[j][i] = 0;
                else dp[j][i] = (dp[j-1][i] + dp[j][i-1])%divider;
            }
        }
        return dp[n][m];
    }
}
