class Day26 {
    public int wordCount(String[] startWords, String[] targetWords) {
        int count=0;
        Set <Integer> seen = new HashSet<>();
        for(String s : startWords){
            seen.add(bitmask(s));
        }
        for(String word : targetWords){
            int bitmask = bitmask(word);
            for(char ch :  word.toCharArray()){
                if(seen.contains(bitmask-(1 << ch-'a'))){
                    count++;
                    break;
                }
            }
           
        }

        return count;
    }

    private int bitmask(String s ){
        int result = 0;
        for(char ch : s.toCharArray()){

            result += 1 << ch-'a';
        }
        return result;
    }
}