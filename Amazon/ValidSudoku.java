class Day11 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!isValid(num, board, i, j)){
                     return false;
                    }
                }
                
            }
        }
        return true;
    }

    private boolean isValid(char num, char[][] board, int row, int col){
        //check for row
        for(int c = col+1; c<9;c++){
            if(board[row][c]==num){
                return false;
            }
        }

        //check for cols
        for(int r=row+1;r<9;r++){
            if(board[r][col]==num){
                return false;
            }
        }

        //check for square
        int x = row - row%3;
        int y= col - col%3;
        for(int r=x; r<x+3; r++){
            for(int c=y; c<y+3; c++){
                if(board[r][c]==num && !(r==row && c==col)){
                    return false;
                }
            }
        }
        return true;
    }
    
}