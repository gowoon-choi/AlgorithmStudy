/*
 * baekjoon #1916 최소비용 구하기
 * BOJ1916.cpp
 * 2020.02.06
 * github.com/choigone
 */

#include <stdio.h>
#include <vector>
#include <queue>

using namespace std;

#define MAX 0x3f3f3f3f
//INF 계산하는 법

int solution(vector<vector<int>> arr, int city, int start, int destination){
    vector<int> result(city);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> distance;
    for(int i=0; i<city; i++){
        distance.push(make_pair(arr[start][i],i));
    }
    result = arr[start];
    distance.pop();
    while(!distance.empty()){
        for(int i=0; i<city; i++){
            // update distance
            int current = distance.top().second;
            if(result[i] > result[current] + arr[current][i]){
                result[i] = result[current] + arr[current][i];
                distance.push(make_pair(result[i],i));
            }
        }
        distance.pop();
    }
    return result[destination];
}

int main(){
    int city, start, destination, bus, cost;
    scanf("%d %d", &city, &bus);
    vector<vector<int>> arr;
    arr.assign(city, vector<int>(city,MAX));

    for(int i=0; i<bus; i++){
        scanf("%d %d %d", &start, &destination, &cost);
        start--;
        destination--;
        if(arr[start][destination] > cost){
            arr[start][start] = 0;
            arr[destination][destination] = 0;
            arr[start][destination] = cost;
        }
    }
    scanf("%d %d", &start, &destination);
    start--;
    destination--;
    printf("%d", solution(arr, city, start, destination));
}
