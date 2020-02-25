/*
 * BOJ #15552 빠른 A+B
 * BOJ15552.cpp
 * 2020.02.25
 * github.com/choigone
 */

#include <iostream>

using namespace std;

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n;
    cin >> n;
    int a, b;
    for(int i=0; i<n; i++){
        cin >> a >> b;
        cout << a+b << '\n';
    }
    return 0;
}
