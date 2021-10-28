import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        while (true) {
            String line = bfr.readLine();
            if (line.equals("0 0 0")) break;
            list.add(line);
        }

        for (int i = 0;  i < list.size(); i++) {
            String[] lpvArray = list.get(i).split(" ");
            int l = Integer.parseInt(lpvArray[0]);
            int p = Integer.parseInt(lpvArray[1]);
            int v = Integer.parseInt(lpvArray[2]);
            int answer = (v/p * l) + Math.min(v%p, l);
            System.out.println("Case "+(i+1)+": "+answer);
        }
    }
}
