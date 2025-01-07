class Day8 {
    static void linkdelete(Node head, int n, int m) {
        
        if(n==0){
            return;
        }
        int counterM = 0;  //counter for skip
        int counterN = 0;  //counter for delete 
        
        Node curr = head;
        Node prev = head;
        
        while(curr!=null){
        
            if(counterM<m){
                prev = curr;
                curr=curr.next;
                counterM++;
            }
            else if(counterN<n){
                curr=curr.next;
                counterN++;
            }
            else if(m==counterM && n==counterN){
               prev.next=curr;
               counterM=0;
               counterN=0;
                
            }
        }
        prev.next = null;
    }
}