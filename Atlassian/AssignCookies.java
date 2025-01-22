class Day23 {
    public int findContentChildren(int[] g, int[] s) {
        
        int glen = g.length;
        int slen = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while(j < slen && i< glen){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }   
           
        return i;
    }
}