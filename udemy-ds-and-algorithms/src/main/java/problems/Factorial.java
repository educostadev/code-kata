package problems;

import java.util.*;
import static java.lang.System.out;

public class Factorial {
    public static void main(String[] args) {
        out.println(Recursive.factorial(5));
        out.println(Iteractive.factorial(5));
    }

    // Base case: When n is 0 return 1
    // Recursion case: n * recusrion(n-1)
    static class Recursive {
        static int factorial(int n) {
            if (n == 0)
                return 1;

            return n * factorial(n - 1);
        }
    }

    // Create an accumulator
    // For each number from 1 to N
    //  accumulator receives accumulator * number
    // Return accumulator
    static class Iteractive {
        static int factorial(int n) {
            int accumulator = 1;
            for (int number = 1; number <= n; number++)
                accumulator *= number;
            return accumulator;
        }
    }
}
