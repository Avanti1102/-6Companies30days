class Day7 {
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            int fi = s.indexOf(s.charAt(i));
            int li= s.lastIndexOf(s.charAt(i));
            if(fi==li){
                return fi;
            } 
        }
       return -1;
    
    }
}