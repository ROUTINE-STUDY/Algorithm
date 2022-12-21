public class Threemusketeers {
    public static void main(String[] args) {
        int[] number = {1,2,3};

        int answer = 0;

        for(int i=0; i<number.length - 2; i++){
            for(int j=i+1; j<number.length - 1; j++){
                for(int k=j+1; j<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0) {answer++;}
                }
            }
        }

        System.out.println(answer);
    }

}
