/*
 * programmers 가장 먼 노드
 * farthestNode.cpp
 * 2020.09.20
 * github.com/gowoon-choi
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    vector<vector<int>> graph(n+1);
    vector<bool> visited(n+1, false);
    for(int i=0; i<edge.size(); i++){
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }

    vector<int> current, next;
    next.push_back(1);
    visited[1] = true;
    while(!next.empty()){
        current = next;
        answer = next.size();
        next.clear();
        for(int i=0; i<current.size(); i++){
            for(int j=0; j<graph[current[i]].size(); j++){
                if(visited[graph[current[i]][j]]){
                    continue;
                }else{
                    next.push_back(graph[current[i]][j]);
                    visited[graph[current[i]][j]] = true;
                }
            }
        }
    }
    return answer;
}

int main(){
    int n, size;
    cin >> n >> size;
    vector<vector<int>> edge;
    for(int i=0; i<size; i++){
        vector<int> a(2);
        cin >> a[0] >> a[1];
        edge.push_back(a);
    }
    cout << solution(n, edge);
    return 0;
}
