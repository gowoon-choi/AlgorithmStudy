class Solution {
    static class Position{
        private int row;
        private int col;
        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
        public void setPosition(Position newPosition){
            this.row = newPosition.row;
            this.col = newPosition.col;
        }
    }

    static int calDistance(Position from, Position to){
        return Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
    }

    static Position[] keypad = {new Position(3, 1), new Position(0, 0), new Position(0, 1), new Position(0, 2),
            new Position(1, 0), new Position(1, 1), new Position(1, 2),
            new Position(2, 0), new Position(2, 1), new Position(2, 2)};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        if(hand.equals("left")) hand = "L";
        else hand = "R";
        
        Position curLeft = new Position(3, 0);
        Position curRight = new Position(3, 2);

        Position current;
        String curHand;
        int distanceL, distanceR;
        for(int i=0; i<numbers.length; i++){
            current = keypad[numbers[i]];
            if(current.col == 0) curHand = "L";
            else if (current.col == 2) curHand = "R";
            else{
                distanceL = calDistance(curLeft, current);
                distanceR = calDistance(curRight, current);
                if(distanceL > distanceR) curHand = "R";
                else if (distanceL < distanceR) curHand = "L";
                else curHand = hand;
            }
            answer.append(curHand);
            
            if(curHand.equals("L")) curLeft.setPosition(current);
            else curRight.setPosition(current);
        }

        return answer.toString();
    }
}
