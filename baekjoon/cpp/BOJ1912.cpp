/*
 * baekjoon #1912
 * BOJ1912.cpp
 * 2019.10.19
 * 최고운 github.com/choigone
 */

/*
 * 점화식
 * i = 0 , arr[i]
 * i > 0 , max(0, f(i-1)) + arr[i]
 */

#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >> n;

    int *num = new int[n];
    for(int i=0;i<n;i++) cin >> num[i];

    int *dp  = new int[n];
    dp[0] = num[0];

    for(int i=1;i<n;i++){
        if(dp[i-1]>0) dp[i] = dp[i-1] + num[i];
        else dp[i] = num[i];
    }

    cout << *max_element(dp,dp+n);

    return 0;
}