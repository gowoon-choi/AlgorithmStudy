/*
 * BOJ #9372 상근이의 여행
 * BOJ9372.cpp
 * 2020.03.18
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

int main(){
    int t;
    cin >> t;
    int n, m;
    for(int i=0; i<t; i++){
        cin >> n >> m;
        int a, b;
        vector<pair<int,int>> arr;
        for(int j=0; j<m; j++){
            cin >> a >> b;
            arr.push_back(make_pair(a,b));
        }
        cout << n-1 << endl;
    }
    return 0;
}
