/*
 *  @file diceRolling.cpp
 *  @date 2019/03/20
 *  @author 최고운 https://github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

class Dice{
public:
    int *num = new int[6]; // top bottom front back left right
    int x,y;

    Dice(int x, int y){
        for(int i=0;i<6;i++){
            num[i] = 0;
        }
        this->x = x;
        this->y = y;
    }

};

class Board{
public:
    int width, length;
    int **board;
    Board(int width,int length){
        this->width = width;
        this->length = length;
        board = new int*[length];
        for(int i=0;i<length;i++){
            board[i] = new int[width];
        }
    }

};

struct Game{
    Dice dice;
    Board board;
    bool isValid;
};

Game exchangeNum(Game game){
    if(game.board.board[game.dice.x][game.dice.y] == 0){
        game.board.board[game.dice.x][game.dice.y] = game.dice.num[1];
    }
    else{
        game.dice.num[1] = game.board.board[game.dice.x][game.dice.y];
        game.board.board[game.dice.x][game.dice.y] = 0;
    }
    return game;
}

//TODO 바깥으로 넘어가려 하는 경우 예외처리
Game move(Game game,int direction){
    game.isValid = true;
    int temp = game.dice.num[1];
    //direction 동서북남
    switch(direction){
        case 1:
            //주사위 굴리기
            if(game.dice.y+1 >= game.board.width){
                game.isValid = false;
                break;
            }
            game.dice.num[1] = game.dice.num[5];
            game.dice.num[5] = game.dice.num[0];
            game.dice.num[0] = game.dice.num[4];
            game.dice.num[4] = temp;
            game.dice.y++;
            exchangeNum(game);
            break;
        case 2:
            if(game.dice.y-1 < 0){
                game.isValid = false;
                break;
            }
            game.dice.num[1] = game.dice.num[4];
            game.dice.num[4] = game.dice.num[0];
            game.dice.num[0] = game.dice.num[5];
            game.dice.num[5] = temp;
            game.dice.y--;
            exchangeNum(game);
            break;
        case 3:
            if(game.dice.x-1 < 0){
                game.isValid = false;
                break;
            }
            game.dice.num[1] = game.dice.num[3];
            game.dice.num[3] = game.dice.num[0];
            game.dice.num[0] = game.dice.num[2];
            game.dice.num[2] = temp;
            game.dice.x--;
            exchangeNum(game);
            break;
        case 4:
            if(game.dice.x+1 >= game.board.length){
                game.isValid = false;
                break;
            }
            game.dice.num[1] = game.dice.num[2];
            game.dice.num[2] = game.dice.num[0];
            game.dice.num[0] = game.dice.num[3];
            game.dice.num[3] = temp;
            game.dice.x++;
            exchangeNum(game);
            break;
    }
    return game;
}

int main() {
    int N,M,x,y,K;
    scanf("%d %d %d %d %d",&N,&M,&x,&y,&K);

    Dice dice = Dice(x,y);
    Board board = Board(M,N);
    Game game{dice,board,true};

    int temp_num = 0;
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board.width;j++){
            scanf("%d",&temp_num);
            board.board[i][j] = temp_num;
        }
    }

    int instruction;
    vector<int> result;
    for(int i=0;i<K;i++){
        scanf("%d",&instruction);
        game = move(game,instruction);
        if(game.isValid) result.push_back(game.dice.num[0]);

    }

    for(int i =0; i<result.size();i++){
        printf("%d\n",result[i]);
    }
    return 0;
}