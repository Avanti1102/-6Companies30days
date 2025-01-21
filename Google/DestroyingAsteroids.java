class Day22 {
    public boolean asteroidsDestroyed(int mas, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long mass = (long)mas;

        for(int i=0;i<n;i++){
            if(mass >= asteroids[i]){
                mass += asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}