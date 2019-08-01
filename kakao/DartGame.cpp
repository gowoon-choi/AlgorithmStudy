#include <iostream>
#include <math.h>
using namespace std;

int main(){
    string input;
    cin >> input;

    string set[3];
    int index = -1;
    int checker = 0;

    for(int i=0;i<input.length();i++){
        if(input[i] >=48 && input[i]<=57 ){
            if((checker+1) == i ){ index --;}
            index++;
            checker = i;
        }
        set[index]+=input[i];
    }

    int num;
    int result[3];
    char bonus, option;

    for(int i=0;i<3;i++){
        option = '!';
        num = set[i][0]-48;
        for(int j=1;j<set[i].length();j++){
            if(set[i][j]>=48 && set[i][j]<=57){
                num = num*10 + (set[i][j]-48);
            }
            if(set[i][j] == 'S' || set[i][j] == 'D' || set[i][j] == 'T'){
                bonus = set[i][j];
            }
            if(set[i][j] == '*' || set[i][j] == '#'){
                option = set[i][j];
            }
        }
        if(bonus == 'S'){ result[i] = num ; }
        else if(bonus == 'D'){ result[i] = pow(num,2); }
        else{ result[i] = pow(num,3); }

        if(option == '*'){
            result[i] = result[i]*2;
            if(i!=0){
                result[i-1] = result[i-1]*2;
            }
        }
        else if(option == '#'){
            result[i] = result[i]*(-1);
        }
    }

    cout << result[0] + result[1] + result[2];
    return  0;
}