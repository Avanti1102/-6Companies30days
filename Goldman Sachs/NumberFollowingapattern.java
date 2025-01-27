class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        String ans = "" ;
        
        int n = S.length(), k;
        int sz = 0, int j=0;
        Stack<Integer> stk = new Stack<>();
        sz = 1; //stack size
        
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='I'){
                j=j+sz;
                
                k=j;
                while(sz>0){
                    ans+=(char)(k+48);
                    k--;
                    sz--;
                }
                stk.push(i);
                sz++;
            }else{
                stk.push(i);
                sz++;
            }
        }
        j=j+sz;
        k=j;
        while(sz>0){
            ans+=(char)(k+48);
            k--;
            sz--;
        }
        return ans;
    }
}