/*
 * baekjoon #2748
 * BOJ2748.cpp
 * 2019.10.19
 * 최고운 github.com/choigone
 */

#include <iostream>

using namespace std;

int main(){
    int n;
    cin >> n;

    long long *dp = new long long[n+1];
    dp[0] = 0;
    dp[1] = 1;

    for(int i=2; i<=n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }

    cout << dp[n];

    return 0;
}