/*
 * Programmers 2016년
 * 2016.cpp
 * 2020.02.26
 * github.com/choigone
 */

#include <iostream>
#include <string>

using namespace std;

string solution(int a ,int b){
    string days[7] = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    int day[12] = {31,29,31,30,31,30,31,31,30,31,30,31};
    int n = -1;
    for(int i=0; i<a-1; i++){
        n+=day[i];
    }
    n+=b;
    n%=7;
    return days[n];
}

int main(){
    int a, b;
    cin >> a >> b;
    cout << solution(a,b);
    return 0;
}
