package Programmers.숫자문자열과영단어;

import java.util.Arrays;

public class Sanghoo {

    public int solution(String s) {
        String[] wordList = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for(int i=0; i<wordList.length; i++) {
            if(s.contains(wordList[i])) {
                s = s.replaceAll(wordList[i], String.valueOf(i));
            }
        }

        return Integer.parseInt(s);
    }

}
