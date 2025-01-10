//class Day11{
    // static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s){
    //brute force approach
        
        // Arrays.sort(contact);
        // String sub = "";
        // ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Set<String> set = new TreeSet<>();
        // for(String st :  contact) {
        //     set.add(st);
        // }
        
        // for(int i=0;i<s.length();i++){
        //     sub = sub + s.charAt(i);
        //     ArrayList<String> temp = new ArrayList<>();
        //     for(String sample : set){
        //         if(i >= sample.length()) continue;
        //         else if(sub.equals(sample.substring(0, i+1))){
        //             temp.add(sample);
        //         }
        //     }
            
        //     if(temp.size()==0){
        //         temp.add("0");
        //     }
            
        //     result.add(temp);
            
        
        // }
       
        
        // return result;
        

//     }
  
//}

//optimal approach using tries

class Trie{
    Map<Character,Set<String>> map;
    Map<Character,Trie> next;
    Trie(){
        map=new HashMap<>();
        next=new HashMap<>();
    }
}


class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        // code here 
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        Trie head=new Trie();
        
        //create trie
        for(String st:contact){
            Trie curr=head;
            for(char c:st.toCharArray()){
                curr.map.putIfAbsent(c,new TreeSet<>());
                curr.map.get(c).add(st);
                curr.next.putIfAbsent(c,new Trie());
                curr=curr.next.get(c);
            }
        }
        
        Trie curr=head;
        for(int i=0;i<s.length();i++){
            ArrayList<String> list=new ArrayList<>();
            if(curr.map.containsKey(s.charAt(i))){
                for(String str:curr.map.get(s.charAt(i))){
                    list.add(str);
                }
            }
            if(list.size()==0)list.add("0");
            ans.add(list);
            
            if(curr.next.containsKey(s.charAt(i))){
                curr=curr.next.get(s.charAt(i));
            }else{
                break;
            }
        }
        while(ans.size()!=s.length()){
            ArrayList<String> list=new ArrayList<>();
            list.add("0");
            ans.add(list);
        }
        return ans;
        
    }
}


