class Day27 {
    public static String encode(String s) {
        // code here
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            }
            
            
        }
        sb.append(count);
        return sb.toString();
        
    }   
}