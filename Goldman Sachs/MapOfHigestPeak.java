class Day27 {
    public int[][] highestPeak(int[][] isWater) {
        int dir[][] = {{-1, 0},{0, 1},{1, 0},{0, -1}};  //up, right, down, left
        int row = isWater.length;
        int col = isWater[0].length;
        int ans[][] = new int[row][col];
        Queue <int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isWater[i][j] == 1){
                    ans[i][j]=0;
                    queue.add(new int[]{i, j});
                }else{
                    ans[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int cell[]  = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int h = ans[r][c];
            for(int i=0;i<4;i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr>=0 && nr<row && nc>=0 && nc<col && ans[nr][nc]==-1){
                    ans[nr][nc]= h+1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return ans;
    }
}