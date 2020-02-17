/*
 * BOJ #2606 바이러스
 * BOJ2606.cpp
 * 2020.02.17
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

int counting = 0;
vector<bool> visited;

void dfs(vector<vector<int>> line, int start){
    visited[start] = true;
    counting++;
    for(int i=0; i<line[start].size(); i++){
        if(!visited[line[start][i]]){
            dfs(line,line[start][i]);
        }
    }
}

int main(){
    int computer, connect;
    cin >> computer >> connect;
    vector<vector<int>> line(computer+1);
    int temp1, temp2;
    for(int i=0; i<connect; i++){
        cin >> temp1 >> temp2;
        line[temp1].push_back(temp2);
        line[temp2].push_back(temp1);
    }
    visited.assign(computer, false);
    dfs(line,1);
    cout << counting-1;
    return 0;
}
