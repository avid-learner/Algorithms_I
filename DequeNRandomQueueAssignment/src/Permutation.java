import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
        int count = Integer.valueOf(args[0]);
        RandomizedQueue<String> strings = new RandomizedQueue<>();
        boolean endOfInput = false;
        while (!endOfInput) {
            try {
                String nextString = StdIn.readString();
                strings.enqueue(nextString);
            } catch(NoSuchElementException e) {
                endOfInput = true;
            }
        }
        for(String s: strings) {
            System.out.println(s);
        }
    }
}
