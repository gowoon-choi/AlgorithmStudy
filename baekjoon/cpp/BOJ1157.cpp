/*
 * BOJ #1157 단어 공부
 * BOJ1157.cpp
 * 2020.02.10
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b){
    return a > b;
}
int main(){
    string input;
    cin >> input;
    transform(input.begin(),input.end(), input.begin(), ::toupper); // all char in string to lower

    vector<int> alpha(26, 0);
    for(int i=0; i<input.length(); i++){
        alpha[input[i]-65]++;
    }

    int maxIndex = max_element(alpha.begin(),alpha.end()) - alpha.begin();
    sort(alpha.begin(),alpha.end(), compare);

    if(alpha[0] == alpha[1]) cout << "?";
    else cout << char(maxIndex+65);

    return 0;
}
