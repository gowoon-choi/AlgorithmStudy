/*
 * baekjoon #1931
 * BOJ1541.cpp
 * 2019.09.23
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >> n;

    vector<pair<int,int>> time;
    int start,end;
    for(int i=0;i<n;i++){
        cin >> start >> end;
        time.push_back(make_pair(end,start));
    }

    sort(time.begin(),time.end());

    int now = 0;
    int count = 0;
    for(int i=0;i<n;i++){
        if(time[i].second >= now){
            now = time[i].first;
            count ++;
        }
    }

    cout << count;

    return 0;
}