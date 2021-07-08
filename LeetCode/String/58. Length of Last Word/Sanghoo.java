package String.Length_of_Last_Word;

public class Sanghoo {

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr.length == 0 ? 0 : arr[arr.length-1].length();
    }

}
