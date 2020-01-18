/*
 * baekjoon1759
 * password.cpp
 * 2019.07.08
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void makePW(vector<char> alpha, string str, int index, int length, int con, int vow, vector<char> vows){
    string result = str;
    int conCnt = con;
    int vowCnt = vow;
    for(int i=index;i<alpha.size();i++){
        str = result;
        con = conCnt;
        vow = vowCnt;
        str+=alpha[i];
        auto iter = find(vows.begin(),vows.end(),alpha[i]);
        if(iter == vows.end()) con++;
        else vow++;
        if(str.length()==length){
            if(con >=2 && vow >=1 ) cout << str << endl;
        }
        else{
            makePW(alpha,str,i+1,length,con,vow,vows);
        }
    }
}

int main() {
    static int numL,numC;
    cin >> numL >> numC;

    vector<char> alphas;
    char temp;
    for(int i=0;i<numC;i++){
        cin >> temp;
        alphas.push_back(temp);
    }
    sort(alphas.begin(),alphas.end());

    string result = "";
    vector<char> vows{'a','e','i','o','u'};
    makePW(alphas,result,0,numL,0,0,vows);

    return 0;
}