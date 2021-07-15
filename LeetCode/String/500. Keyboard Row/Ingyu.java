class Solution {
    public String[] findWords(String[] words) {
        List<String> answer = new ArrayList<>();
        final String[] keyboardArray = new String[]{"qwertyuiop", "asdfghjkl","zxcvbnm"};

        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < keyboardArray.length; i++) {
            Set<Character> set = new HashSet<>();
            for (char c : keyboardArray[i].toCharArray()) {
                set.add(c);
            }
            list.add(set);
        }

        for (String word : words) {
            boolean haveToAdd = false;
            String temp = word.toLowerCase();
            for (Set set : list) {
                if (set.contains(temp.charAt(0))) haveToAdd = isAllContains(temp,set);
            }
            if (haveToAdd) answer.add(word);
        }

        String[] strArray = new String[answer.size()];
        return answer.toArray(strArray);
    }

    public boolean isAllContains(String word, Set<Character> set) {
        for (int i = 1; i < word.length(); i++) {
            if (!set.contains(word.charAt(i))) return false;
        }
        return true;
    }
}