/*
 * SWEA #2072 홀수만 더하기
 * SWEA2072.cpp
 * 2020.03.21
 * github.com/choigone
 */

#include <iostream>

using namespace std;

int main(){
    int t;
    cin >> t;
    int sum, temp;
    for(int test=0; test<t; test++){
        sum = 0;
        for(int i=0; i<10; i++){
            cin >> temp;
            if(temp%2 == 1) sum+=temp;
        }
        cout << "#" << test+1 << " " << sum << endl;
    }
    return 0;
}
