#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int checker(string word);

int main() {
    int count;
    cin >> count;

    string list[count];
    for(int i=0;i<count;i++)
    {
        cin >> list[i];
    }

    int count2 = 0;
    for(int i = 0; i<count;i++){
        if(checker(list[i])) count2++;
    }

    cout << count2;
    return 0;
}

int checker(string word){
    int i;
    vector<char> checker;
    for( i = 1; i < word.length(); i++){
        if(word[i] != word[i-1]){
            checker.push_back(word[i-1]);
        }
    }
    checker.push_back(word[i-1]);
    int size1 = checker.size();

    sort(checker.begin(),checker.end());
    checker.erase(unique(checker.begin(),checker.end()),checker.end());
    int size2 = checker.size();

    if(size1 == size2){
        return 1;
    }
    else return 0;
}