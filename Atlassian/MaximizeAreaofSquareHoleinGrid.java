class Day24 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h=1, v=1;
        int count = 1;

        for(int i = 1; i < hBars.length; i++){
            if(hBars[i] == hBars[i - 1] + 1){
                count++;
            }else{
                count=1;             
            }
            h = Math.max(count, h);   
        }

        count = 1;

        for(int i = 1; i < vBars.length; i++){
            if(vBars[i] == vBars[i - 1] + 1){
                count++;
            }else{
                count=1;
            }
            v = Math.max(count, v);

        }
        int ans = Math.min(h+1, v+1);
        
        return ans*ans;
    }
    
}