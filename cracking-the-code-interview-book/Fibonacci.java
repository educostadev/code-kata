import java.util.*;
import static java.lang.System.out;

// A series of number in which each number is the sum of the two preceding numbers.
// Fn = Fn-1 + Fn-2
// The first two terms of the series are 0, 1.
// For example: fib(0) = 0, fib(1) = 1, fib(2) = 1, fib(9) = 34
// Ex. 0,1,1,2,3,5,8,13,21,34,55,89,144
class Fibonacci {
    public static void main(String args[]) {
        out.println("R:" + Recursive.fibonacci(10));
        out.println("I:" + Iteractive.fibonacci(10));
    }

    static class Recursive {
        static int fibonacci(int n) {
            if (n == 0 || n == 1)
                return n;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    static class Iteractive {
        // If N 0 or 1 return N
        // Initialize previousFib = 0
        // Initialize currentFib = 1
        // For each number from 2 until N
        // Initialize previousFibTmp with previousFib;
        // previousFib receives currentFib
        // currentFib += previousFibTmp
        // In the end return currentFib
        static int fibonacci(int n) {
            if (n == 0 || n == 1)
                return n;

            int previousFib = 0;
            int currentFib = 1;
            for (int step = 2; step <= n; step++) {
                int previousFibTmp = previousFib;
                previousFib = currentFib;
                currentFib += previousFibTmp;
            }
            return currentFib;
        }

    }
}