class Solution {
    public int[] diStringMatch(String s) {
        int[] ret = new int[s.length()+1];
        int icount = 0;
        int dcount = s.length();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'I'){
                ret[i] = icount;
                icount++;
            }else if(s.charAt(i) == 'D'){
                ret[i] = dcount;
                dcount--;
            }
        }
        ret[s.length()] = icount++;
        
        return ret;
    }
}