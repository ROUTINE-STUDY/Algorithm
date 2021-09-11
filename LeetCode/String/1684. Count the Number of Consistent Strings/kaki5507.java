class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int count=0;
        
		for(String word : words){
            boolean poham = true;
            for(int j=0; j<word.length(); j++){
                if(allowed.indexOf(word.charAt(j)) == -1){
                    poham = false;
                    break;
                }
            }
            if(poham){
                count++;
            }
        }
        
        return count;
    }
}