/*
 * SWEA #7829 보물왕 태형이
 * SWEA7829.cpp
 * 2020.02.20
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int t, n;
    cin >> t;
    vector<int> nums;
    for(int i=0; i<t; i++){
        cin >> n;
        nums.assign(n,NULL);
        for(int i=0; i<n; i++){
            cin >> nums[i];
        }
        sort(nums.begin(),nums.end());
        cout << "#" << i+1 << " " << nums[0]*nums[n-1] << endl;
    }

    return 0;
}
