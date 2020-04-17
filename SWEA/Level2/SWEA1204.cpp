/*
 * SWEA #1204 최빈수 구하기
 * SWEA1204.cpp
 * 2020.04.15
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define COUNT 1000
#define MAX 100

int main(){
    vector<int> arr;
    int t, n, result;
    cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        arr.assign(MAX+1,0);
        for(int j=0; j<COUNT; j++){
            cin >> n;
            arr[MAX-n]++;
        }
        result = max_element(arr.begin(),arr.end()) - arr.begin();
        cout << "#" << i+1 << " " << MAX-result << endl;
    }
    return 0;
}
