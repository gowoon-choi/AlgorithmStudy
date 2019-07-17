/*
 * baekjoon #1405
 * nQueens.cpp
 * 2019.07.17
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool promising(int n, vector<int> arr, int count){
    if(count == arr.size()) return true;
    else{
        auto iter = find(arr.begin(),arr.end(),n);
        if(iter == arr.end()){
            for(int i=0;i<=(arr.size()-count);i++){
                if(abs(arr[arr.size()-count-i] - n) == i ) return false;
            }
            return true;
        }
        else false;
    }
}

int nQueen(int n, vector<int> arr, int result, int count){
    if(count == 0){
        result++;
    }
    else{
        for(int i=0;i<n;i++){
            if(promising(i,arr,count)){
                arr[n-count] = i;
                result = nQueen(n,arr,result,count-1);
            }
            else{
                continue;
            }
        }
    }
    return result;
}

int main(){
    int n;
    cin >> n;

    vector<int> arr(n,-1);
    cout << nQueen(n,arr,0,n);

    return 0;
}
