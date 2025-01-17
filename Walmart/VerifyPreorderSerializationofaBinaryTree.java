class Day18 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int in = 1;
        int out =0;
        for( String node : nodes){
            in--;
            if(out + in < 0)  return false;
            if(!node.equals("#"))  out +=2;
        }
        return out+in == 0;
    }
}