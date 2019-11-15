package problems.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * For each element find the the minimum value index starting at current index and
 * swap the value at the minimun index with the value in the current position when it is lower. 
 * 
 * Minimum elementss are going to the beggining of the array
 */
public class SelectionSort {

    public static void main(String[] args) {
        int array[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };
        System.out.println("User entered Array: ");
        SelectionSort.printArray(array);

        SelectionSort.sort(array);

        System.out.println("\n\nAfter sorting: ");
        SelectionSort.printArray(array);

        System.out.println("\n");
        int a[] = { 10, 5 };
        SelectionSort.sort(a);
        SelectionSort.printArray(a);

    }// end of method

    static void sort(int[] array) {
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            int minimumIndex = FindMininum.on(array).startOn(currentIndex);
            if (minimumIndex != currentIndex) {
                Swap.valueAtIndex(minimumIndex).withValueAtIndex(currentIndex).on(array);
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }// end of method

    static class FindMininum {
        final int[] array;

        static FindMininum on(int[] array) {
            return new FindMininum(array);
        }

        FindMininum(int[] array) {
            this.array = array;
        }

        int startOn(int startIndex) {
            int minimumIndex = startIndex;
            for (int i = startIndex + 1; i < array.length; i++) {
                if (array[i] < array[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            return minimumIndex;
        }
    }

    static class Swap {
        int index1;
        int index2;

        static Swap valueAtIndex(int i) {
            Swap s = new Swap();
            s.index1 = i;
            return s;
        }

        Swap withValueAtIndex(int i) {
            this.index2 = i;
            return this;
        }

        void on(int[] array) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

    }

}// end of class
