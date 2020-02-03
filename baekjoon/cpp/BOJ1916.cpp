/*
 * baekjoon #1916 최소비용 구하기
 * BOJ1916.cpp
 * 2020.01.18
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

#define MAX 100001
#define CITY_NUM 1001

int city, start, destination;

int solution(vector<vector<int>> arr){
    vector<int> s(city,CITY_NUM);
    vector<int> distance = arr[start];
    s[start] = start;
    while(*max_element(s.begin(),s.end()) == CITY_NUM){
        int current  = min_element(s.begin(),s.end())-s.begin(); // min element index
        s[current] = current;
        for(int i=0; i<city; i++){
            // TODO 가중치 변경 짜기 !
        }
    }
    return distance[destination];
}

int main(){
    int bus, cost;
    cin >> city >> bus;
    vector<vector<int>> arr;
    arr.assign(city, vector<int>(city,MAX));

    for(int i=0; i<bus; i++){
        cin >> start >> destination >> cost;
        start--;
        destination--;
        arr[start][start] = 0;
        arr[destination][destination] = 0;
        arr[start][destination] = cost;
        arr[destination][start] = cost;
    }
    cin >> start >> destination;
    start--;
    destination--;
    cout << solution(arr);
}
