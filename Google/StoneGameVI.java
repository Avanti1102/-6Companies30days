class Day29 {
    class Pair{
        int sum;
        int idx;
        Pair(int sum, int idx){
            this.sum=sum;
            this.idx=idx;
        }
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Pair p[]= new Pair[n];
        for(int i=0;i<n;i++){
            p[i] = new Pair(aliceValues[i]+bobValues[i], i);
        }
        //sort pair descending order
        Arrays.sort(p, (a, b)-> b.sum - a.sum);

        int asum = 0, bsum=0;
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                asum += aliceValues[p[i].idx];
            }else{
                bsum += bobValues[p[i].idx];
            }
        }
        return asum == bsum ? 0 : (asum > bsum ? 1: -1);

    }
}