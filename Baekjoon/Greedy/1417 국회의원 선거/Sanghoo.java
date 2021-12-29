package BaekJoon.국회의원선거_1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1417
 */
public class Sanghoo {

    private static final int[] votes = new int[50];

    public static void main(String[] args) throws IOException {
        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int voteCount = Integer.parseInt(br.readLine());
            for(int i=0; i<voteCount; i++) {
                votes[i] = Integer.parseInt(br.readLine());
            }
        }

        int buyVoteCount = getBuyVoteCount();

        System.out.println(buyVoteCount);
    }

    private static int getBuyVoteCount() {
        int dasomVote = votes[0];
        int buyVote = 0;
        votes[0] = 0;

        while(true) {
            Arrays.sort(votes);
            int maxVote = votes[votes.length-1];

            if(dasomVote > maxVote) break;

            votes[votes.length-1]--;
            dasomVote++;
            buyVote++;
        }
        return buyVote;
    }

}
