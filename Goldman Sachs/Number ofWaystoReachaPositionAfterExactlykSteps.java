class Day29 {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {

        int[][] dp = new int[5001][1001];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int maxDis = Math.abs(k-startPos);

        return totalWays(startPos, endPos, dp, k, startPos)%mod;
    }

    public int totalWays(int start, int end, int [][] dp, int k, int curr){
        if(k==0){
            if(curr==end){
                return 1;
            }
            return 0;
        }

        if(dp[curr+1000][k] != -1){
            return dp[curr+1000][k]%mod;
        }

        return dp[curr+1000][k] = (totalWays(start, end, dp, k-1, curr+1)%mod + totalWays(start, end, dp, k-1, curr-1)%mod)%mod; 
    }
}