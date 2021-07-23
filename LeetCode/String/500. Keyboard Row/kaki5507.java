class Solution {
    public String[] findWords(String[] words) {
        
        String[] line = {"^[QWERTYUIOP]*$","^[ASDFGHJKL]*$","^[ZXCVBNM]*$"};
	    
        ArrayList<String> arr = new ArrayList<String>();
	    
	    for(int i = 0; i<words.length; i++) {
	    	
	    	if(words[i].indexOf(line[0].charAt(0)) != 0) {
	    		if(words[i].toUpperCase().matches(line[0]) == true) {
	    			arr.add(words[i]);
	    		}
	    	}
	    	if(words[i].indexOf(line[1].charAt(0)) != 0) {
	    		if(words[i].toUpperCase().matches(line[1]) == true) {
	    			arr.add(words[i]);
	    		}
	    	}
	    	if(words[i].indexOf(line[2].charAt(0)) != 0) {
	    		if(words[i].toUpperCase().matches(line[2]) == true) {
	    			arr.add(words[i]);
	    		}
	    	}
	    }
        String[] reArr = new String[arr.size()];
	    for(int i=0; i<arr.size(); i++) {
	    	reArr[i] = arr.get(i).toString();
	    }
        return reArr;
    }
}
/*
    String 배열로 리턴해줘야 합니다.
    1. 첫 글자가 대문자기 때문에 대문자로 비교해주고, 정규식을 비교할때는 나머지를 대문자로 바꿔줍니다.
    2. 첫 글자를 먼저 비교하고 -1이면 해당 if문에 들어가서 나머지를 대문자로 바꿔준 뒤 비교합니다.
    3. return은 String배열로 줘야하기 때문에 reArr[]을 만들어줘서 arr의 요소들을 반복문을 통해 넣어줍니다.
    

*/