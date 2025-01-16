class Day17 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

//send way of solving

    /*private Map<String, Boolean> dp;

    public boolean solve(String s, Set<String> m) {
        if (s.length() == 0) {
            return true;
        }
        if (dp.containsKey(s))
            return dp.get(s);
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(0, i + 1);
            if (m.contains(r)) {
                if (solve(s.substring(i + 1), m)){
                    dp.put(s,true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return solve(s, m);
    }*/
       
}