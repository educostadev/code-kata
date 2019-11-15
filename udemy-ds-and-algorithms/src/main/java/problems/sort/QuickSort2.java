package problems.sort;

/*
 * Algorithm: Quick Sort Input: Non ordered array of integers Output: Ordered
 * array of integers
 * 
 * If array is 0 our 1 return array (Base Case) Pick the first element as pivot
 * Split the array into one array with number lower than pivot and other higher
 * the pivot Call quicksort on the lower array join with pivot number and joing
 * with the quicksort on the higher array
 * 
 */
public class QuickSort2 {

    public static void main(String[] args) {
        Integer array[] = { 10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11 };

        System.out.println("User entered Array: ");
        QuickSort2.printArray(array);

        Integer sorted[] = QuickSort2.sort(array);

        System.out.println("\n\nAfter sorting: ");
        QuickSort2.printArray(sorted);
    }// end of method

    static Integer[] sort(Integer[] array) {

        if (array.length < 2) {
            return array;
        }
        int pivot = array[0];
        Integer[] lowerArray = new Integer[0];
        Integer[] higherArray = new Integer[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < pivot) {
                lowerArray = addOnTheEnd(lowerArray, array[i]);
            } else {
                higherArray = addOnTheEnd(higherArray, array[i]);
            }
        }
        return joinArray(sort(lowerArray), pivot, sort(higherArray));

    }

    private static Integer[] joinArray(final Integer[] lower, final int pivot, final Integer[] higher) {
        Integer[] value = new Integer[lower.length + higher.length + 1];
        for (int i = 0; i < lower.length; i++)
            value[i] = lower[i];

        value[lower.length] = pivot;

        for (int i = 0; i < higher.length; i++)
            value[i + lower.length + 1] = higher[i];

        return value;
    }

    static Integer[] addOnTheEnd(Integer[] input, int pivot) {
        Integer[] tmpLower = new Integer[input.length + 1];
        tmpLower[input.length] = pivot;
        for (int x = 0; x < input.length; x++)
            tmpLower[x] = input[x];
        return tmpLower;
    }

    public static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }// end of method

}