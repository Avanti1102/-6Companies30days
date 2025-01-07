class Day8 {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder sb = new StringBuilder("");
        int col = columnNumber;
        while(col>0){
            col--; 
            int r = col % 26;
            sb.append((char)(r + 'A'));   
            //when we add any char to int java converts char to their ascii number and add that number
            //with int num type casting to char will return corresponding char val
            col /= 26;
        }
        return sb.reverse().toString();
    }
}