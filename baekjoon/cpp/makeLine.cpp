/*
 * baekjoon #2252
 * makeLine.cpp
 * 2019.07.24
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int n,m;
    cin >> n >> m;
    vector<vector<int>> graph(n);
    vector<int> inCount(n,0);
    int tmp1,tmp2;
    for(int i=0;i<m;i++){
        cin >> tmp1 >> tmp2;
        graph[tmp1-1].push_back(tmp2);
        inCount[tmp2-1]++;
    }

    int count = 0;
    int i = 0;
    while(count < n){
        if(inCount[i] == 0){
            cout << i+1 << " ";
            count++;
            for(int j=0;j<graph[i].size();j++){
                inCount[graph[i][j]-1]--;
            }
        }
        i = (i+1)%n;
    }

    return 0;
}