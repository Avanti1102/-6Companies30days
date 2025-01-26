class Day27 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //noOfPeopleSharingSecret on ith day-> dp[i-delay]
        //noOfPeopleForgetingSecret on ith day-> dp[i-forget]

        //apply formula at every day
        //noOfPeopleSharingSecret = (noOfPeopleSharingSecret + noOfPeopleSharingSecret- noOfPeopleForgetingSecret)
        long dp[] = new long[n+1];
        long mod = (long)1e9+7;
        long noOfPeopleSharingSecret = 0;
        long ans =0;

        dp[1] =1;

        for(int i=2;i<=n;i++){
            long noOfPeopleSharing = dp[Math.max(i-delay, 0)];
            long noOfPeopleForgetingSecret = dp[Math.max(i - forget, 0)];
            noOfPeopleSharingSecret += (noOfPeopleSharing - noOfPeopleForgetingSecret + mod)%mod;
            //dp[i] means no of people who found the secret on ith day
            dp[i] = noOfPeopleSharingSecret;
        }

        for(int i=n-forget+1; i<=n ;i++){
            ans = (ans+dp[i])%mod;
        }
        return (int)ans;
    }
}