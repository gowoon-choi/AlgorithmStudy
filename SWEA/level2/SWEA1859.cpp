/*
 * SWEA #1859 백만 장자 프로젝트
 * SWEA1859.cpp
 * 2020.02.25
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

int main(){
    int test,n;
    cin >> test;
    for(int i=0; i<test; i++){
        cin >> n;
        vector<int> arr(n);
        for(int j=0; j<n; j++){
            cin >> arr[j];
        }

        int target = arr[n-1];
        long long result = 0;
        for(int j=n-2; j>=0 ; j--){
            if(arr[j] < target){
                result+=(target - arr[j]);
            }
            else{
                target = arr[j];
            }
        }
        cout << "#" << i+1 << " " << result << endl;
    }
    return 0;
}
