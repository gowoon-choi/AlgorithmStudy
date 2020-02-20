/*
 * SWEA #9317 석찬이의 받아쓰기
 * SWEA9317.cpp
 * 2020.02.20
 * github.com/choigone
 */

#include <iostream>

using namespace std;

int main(){
    int t, n, count;
    cin >> t;
    char *s1, *s2;
    for(int i=0; i<t; i++){
        count=0;
        cin >> n;
        s1 = new char[n];
        s2 = new char[n];
        cin >> s1;
        cin >> s2;
        for(int j=0; j<n; j++){
            if(s1[j]-s2[j] != 0) count++;
        }
        cout << "#" << i+1 << " " << n-count;
    }

    return 0;
}
