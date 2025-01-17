class Day18 {

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean withinRange(int d1, int d2, int c1, int c2, long mid) {
        int notDivisiblebyd1 = (int) (mid - mid / d1);
        int notDivisiblebyd2 = (int) (mid - mid / d2);
        long lcm = ((long)d1 * (long)d2) / gcd(d1, d2);
        int notDivisiblebyboth = (int) (mid - mid / lcm);

        if (notDivisiblebyd1 >= c1 && notDivisiblebyd2 >= c2 && notDivisiblebyboth >= c1 + c2) {
            return true;
        }

        return false;
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long l = 1, h = Integer.MAX_VALUE;
        long ans = h;
        while (l <= h) {
            long mid = l + (h-l)/2;
            if (withinRange(divisor1, divisor2, uniqueCnt1, uniqueCnt2, mid)) {
                ans = Math.min(ans, mid);
                h = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}