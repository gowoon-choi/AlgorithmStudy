/*
 * BOJ #1697 숨바꼭질
 * BOJ1697.cpp
 * 2020.04.18
 * github.com/choigone
 */

#include <iostream>
#include <queue>

using namespace std;

#define MAX 100000

int bfs(int n, int k){
    int visited[MAX+1] = {0,};
    queue<pair<int,int>> q;
    q.push(make_pair(0,n));
    visited[n] = 1;
    pair<int,int> current;
    int next[3];
    while(!q.empty()){
        current = q.front();
        if(current.second == k){
            break;
        }
        next[0] = current.second+1;
        next[1] = current.second-1;
        next[2] = current.second*2;
        for(int i=0; i<3; i++){
            if(next[i] < 0 || next[i] > MAX){
                continue;
            }
            if(visited[next[i]] == 0){
                q.push(make_pair(q.front().first+1,next[i]));
                visited[next[i]] = 1;
            }
        }
        q.pop();
    }
    return q.front().first;
}

int main() {
    int n, k;
    cin >> n >> k;
    cout << bfs(n,k);
    return 0;
}
