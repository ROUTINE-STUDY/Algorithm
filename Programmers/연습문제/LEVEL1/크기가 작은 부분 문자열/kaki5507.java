public class smallStr {
    public static void main(String[] args) {
        String t = "500220839878";    // 7   5번
        String p = "7"; // 3

        int cnt = 0;
        for(int i=0; i<t.length() - p.length() + 1; i++){
            String tmp = t.substring(i , i + p.length());
            if(Long.parseLong(p) >= Long.parseLong(tmp)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}