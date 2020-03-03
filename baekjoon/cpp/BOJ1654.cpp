/*
 * BOJ #1654 랜선 자르기
 * BOJ1654.cpp
 * 2020.03.03
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

int main(){
    int k, n;
    cin >> k >> n;
    vector<int> lines(k);
    long long max = 0;
    for(int i=0; i<k; i++){
        cin >> lines[i];
        max+=lines[i];
    }
    long long left = 1;
    long long right = max/n;
    int count;
    long long mid;
    while(left <= right){
        count = 0;
        mid = (left+right)/2;
        for(int i=0; i<k; i++) count += lines[i]/mid;
        if(count < n) right = mid-1;
        else left = mid+1;
    }
    long long result = (left < right) ? left : right;
    cout << result;
    return 0;
}
