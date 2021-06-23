package Sort.Sorting_the_Sentence;

/**
 * https://leetcode.com/problems/sorting-the-sentence/
 */
public class Sanghoo {

    // 각 단어의 맨 끝에있는 숫자가 곧 배열 인덱스 자리라 생각하고 재배치 후 문자열 합치는 방식
    public static String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] result = new String[arr.length + 1];

        for(int i=0; i<arr.length; i++) {
            String word = arr[i];
            int len = word.length();
            result[word.charAt(len - 1) - '0'] = word.substring(0, len-1);
        }

        StringBuilder res = new StringBuilder();
        for(int i=1; i<result.length; i++) {
            res.append(result[i]).append(" ");
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
