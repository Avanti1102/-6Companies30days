class Day15 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
       int n = ages.length;
       int x = 0;
       int y= 0;
       int repeat = 0;
       int count=0;
       for(x = 1; x < n; x++){
            if(ages[x] < 100 && ages[y] > 100) continue;
            while(y < x && ages[y] <= 0.5 * ages[x] + 7){
                 y++; // move y if not meet the condition
            }
            while(repeat < x && ages[x] != ages[repeat]) {
                repeat++;
            } // move repeat if not same
            if(ages[x] == ages[repeat] && ages[x] > 0.5 * ages[x] + 7) {
                count += x - repeat; // for the same val, check if the numer is valid and then set the repeat window count
            }
            count += x - y;
            // set the other half of the window
        }
        return count;
    }
}