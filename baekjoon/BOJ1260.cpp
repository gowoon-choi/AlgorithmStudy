/*
 * baekjoon #1260 DFS와 BFS
 * BOJ1260.cpp
 * 2019.10.28
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;

// using queue
void bfs(vector<vector<int>> graph ,int node){
    vector<bool> visited(graph.size(),false);
    queue<int> q;

    q.push(node);
    visited[node] = true;
    while(!q.empty()){
        cout << q.front() << " ";
        for(int i=0; i<graph[q.front()].size();i++){
            if(visited[graph[q.front()][i]] == false){
                q.push(graph[q.front()][i]);
                visited[graph[q.front()][i]] = true;
            }
        }
        q.pop();
    }
}

// using recursion
// vector call by reference
void dfs1(vector<vector<int>> graph , int node, vector<bool> &visited){
    cout << node << " ";
    visited[node] = true;
    for(int i=0; i<graph[node].size(); i++){
        if(visited[graph[node][i]] == false){
            dfs1(graph,graph[node][i],visited);
        }
    }
}

// using stack
void dfs2(vector<vector<int>> graph ,int node){
    vector<bool> visited(graph.size(),false);
    stack<int> s;

    cout << node << " ";
    visited[node] = true;
    s.push(node);
    while(!s.empty()){
        int cur = s.top();
        s.pop();
        for(int i=0; i<graph[cur].size(); i++){
            int next = graph[cur][i];
            if(visited[next] == false){
                cout << next << " ";
                visited[next] = true;
                s.push(cur);
                s.push(next);
                break;
            }
        }
    }
}

int main(){
    int node, edge, first;
    cin >> node >> edge >> first;

    vector<vector<int>> graph(node+1);
    int temp1, temp2;
    for(int i=0; i<edge; i++){
        cin >> temp1 >> temp2;
        graph[temp1].push_back(temp2);
        graph[temp2].push_back(temp1);
    }

    for(int i=0; i<node; i++){
        sort(graph[i+1].begin(),graph[i+1].end());
    }

    vector<bool> visited(graph.size(),false);
    dfs1(graph,first,visited);

    dfs2(graph,first);

    cout<< endl;

    bfs(graph,first);

    return 0;
}