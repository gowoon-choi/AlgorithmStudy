/*
 * baekjoon #1026
 * treasure.cpp
 * 2019.09.16
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    //init
    int n,temp;
    cin >> n;
    vector<int> a;
    vector<int> b;
    for(int i=0;i<n;i++){
        cin >> temp;
        a.push_back(temp);
    }
    for(int i=0;i<n;i++){
        cin >> temp;
        b.push_back(temp);
    }

    sort(a.begin(),a.end());
    sort(b.begin(),b.end());

    temp = 0;
    for(int i=0;i<n;i++){
        temp+=(a[i]*b[n-i-1]);
    }

    cout << temp;

    return 0;
}

