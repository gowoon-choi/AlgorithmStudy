/*
 * baekjoon #2751 수 정렬하기2
 * BOJ2751.cpp
 * 2019.11.16
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >> n;

    vector<int> nums(n);
    for(int i=0; i<n; i++){
        cin >> nums[i];
    }

    sort(nums.begin(),nums.end());
    nums.erase(unique(nums.begin(),nums.end()),nums.end());

    for(int i=0; i<nums.size()-1; i++){
        cout << nums[i] << "\n";
    }
    cout << nums[nums.size()-1];

    return 0;
}