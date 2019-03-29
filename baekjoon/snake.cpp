#include <iostream>
#include <vector>

#define APPLE 100

using namespace std;

class Snake{
public:
    vector<pair<int,int>> body;
    char direction;
    Snake(){
        pair<int,int> start = make_pair(0,0);
        body.push_back(start);
        direction = 'E';
    }
};

class Board{
public:
    int size;
    int **board;
    Board(int size,vector<pair<int,int>> apple){
        this->size = size;
        board = new int*[size];
        for(int i=0;i<size;i++){
            board[i] = new int[size];
        }
        for(int i=0;i<apple.size();i++){
            board[apple[i].first-1][apple[i].second-1] = APPLE;
        }
        board[0][0] = 1;
    }
};


struct Game{
    Snake snake;
    Board board;
    int time;
    bool isEnded;
    bool isFinal;
};

Game changeBoard(Game game, bool isApple){
    //꼬리 지우기
    if(!isApple){
        game.board.board[game.snake.body.front().first][game.snake.body.front().second] = 0;
        game.snake.body.erase(game.snake.body.begin());
    }
    //머리 추가하기
    game.board.board[game.snake.body.back().first][game.snake.body.back().second] = 1;
    return game;
}

Game move(Game game, char direction, int step){
    int next;
    bool isApple;
    switch(game.snake.direction){
        case 'E':
            for(int i=0;i<step;i++){
                next = game.snake.body.back().second+1;
                isApple = false;
                game.time++;
                //벗어나면
                if(next == game.board.size){
                    game.isEnded = true;
                    break;
                }
                //자기몸에 부딛히면
                if(game.board.board[game.snake.body.back().first][next] == 1){
                    game.isEnded = true;
                    break;
                }
                //정상적이동
                game.snake.body.push_back(make_pair(game.snake.body.back().first,next));
                //사과 있으면
                if(game.board.board[game.snake.body.back().first][next] == APPLE){
                    isApple = true;
                }
                game = changeBoard(game,isApple);
            }
            //머리 방향 바꿔주기
            if(!game.isFinal) {
                if (direction == 'L') {
                    game.snake.direction = 'N';
                } else if (direction == 'D') {
                    game.snake.direction = 'S';
                }
            }
            break;
        case 'W':
            for(int i=0;i<step;i++){
                next = game.snake.body.back().second-1;
                isApple = false;
                game.time++;
                //벗어나면
                if(next == -1){
                    game.isEnded = true;
                    break;
                }
                //자기몸에 부딛히면
                if(game.board.board[game.snake.body.back().first][next] == 1){
                    game.isEnded = true;
                    break;
                }
                //정상적이동
                game.snake.body.push_back(make_pair(game.snake.body.back().first,next));
                //사과 있으면
                if(game.board.board[game.snake.body.back().first][next] == APPLE){
                    isApple = true;
                }
                game = changeBoard(game,isApple);
            }
            //머리 방향 바꿔주기
            if(!game.isFinal) {
                if (direction == 'L') {
                    game.snake.direction = 'S';
                } else if (direction == 'D') {
                    game.snake.direction = 'N';
                }
            }
            break;
        case 'S':
            for(int i=0;i<step;i++){
                next = game.snake.body.back().first+1;
                isApple = false;
                game.time++;
                //벗어나면
                if(next == game.board.size){
                    game.isEnded = true;
                    break;
                }
                //자기몸에 부딛히면
                if(game.board.board[next][game.snake.body.back().second] == 1){
                    game.isEnded = true;
                    break;
                }
                //정상적이동
                game.snake.body.push_back(make_pair(next,game.snake.body.back().second));
                //사과 있으면
                if(game.board.board[next][game.snake.body.back().second] == APPLE){
                    isApple = true;
                }
                game = changeBoard(game,isApple);
            }
            //머리 방향 바꿔주기
            if(!game.isFinal) {
                if (direction == 'L') {
                    game.snake.direction = 'E';
                } else if (direction == 'D') {
                    game.snake.direction = 'W';
                }
            }
            break;
        case 'N':
            for(int i=0;i<step;i++){
                next = game.snake.body.back().first-1;
                isApple = false;
                game.time++;
                //벗어나면
                if(next == -1){
                    game.isEnded = true;
                    break;
                }
                //자기몸에 부딛히면
                if(game.board.board[next][game.snake.body.back().second] == 1){
                    game.isEnded = true;
                    break;
                }
                //정상적이동
                game.snake.body.push_back(make_pair(next,game.snake.body.back().second));
                //사과 있으면
                if(game.board.board[next][game.snake.body.back().second] == APPLE){
                    isApple = true;
                }
                game = changeBoard(game,isApple);
            }
            //머리 방향 바꿔주기
            if(!game.isFinal){
                if(direction == 'L'){
                    game.snake.direction = 'W';
                }
                else if(direction == 'D'){
                    game.snake.direction ='E';
                }
            }
            break;
    }
    return game;
}

int main(){
    int size,apple_num,instruct_num;
    vector<pair<int,int>> apple;
    vector<pair<int,char>> instruction;
    cin >> size;
    cin >> apple_num;
    pair<int,int> temp_ap;
    for(int i=0; i<apple_num;i++){
        cin >> temp_ap.first >> temp_ap.second;
        apple.push_back(temp_ap);
    }
    cin >> instruct_num;
    pair<int,char> temp_inst;
    for(int i=0;i<instruct_num;i++){
        cin >> temp_inst.first >> temp_inst.second;
        instruction.push_back(temp_inst);
    }

    Snake snake = Snake();
    Board board = Board(size,apple);
    Game game{snake, board, 0, false, false};

    for(int i=0;i<instruct_num;i++){
        game = move(game,instruction[i].second,instruction[i].first - game.time);
        if(game.isEnded) break;
    }
    game.isFinal = true;
    while(true){
        if(game.isEnded) break;
        game = move(game,game.snake.direction,1);
    }
    cout << game.time;
}