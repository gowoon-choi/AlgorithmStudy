/*
 * programmers 입국 심사
 * immigration.cpp
 * 2020.09.18
 * github.com/gowoon-choi
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long left, right, mid;
    long long sum;
    sort(times.begin(), times.end());
    left = 0;
    right = (long long)n*times[times.size()-1];
    answer = right;
    while(left<=right){
        mid = (left+right)/2;
        sum = 0;
        for(int i=0; i<times.size(); i++) sum += (mid/times[i]);
        if(sum >= n){
            if(answer > mid) answer = mid;
            right = mid - 1;
        }
        else if(n > sum) left = mid + 1;
    }
    return answer;
}

int main(){
    int n, size;
    cin >> n >> size;
    vector<int> times(size);
    for(int i=0; i<size; i++) cin >> times[i];
    cout << solution(n, times);
    return 0;
}
