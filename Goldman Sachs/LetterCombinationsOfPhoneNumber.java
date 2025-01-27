class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(result, new StringBuilder(), digits, 0, map);
        return result;
         
    }
    public void backtrack(List<String> result, StringBuilder curr, String digits, int index, String[] map){
        if(index == digits.length()){
            result.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String chars = map[digit];

        for(char c : chars.toCharArray()){
            curr.append(c);
            backtrack(result, curr, digits, index+1, map);
            curr.deleteCharAt(curr.length()-1);
        }
    }
 }