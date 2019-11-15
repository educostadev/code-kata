package problems.sort;

public class QuickSort {

    public static void main(String[] args) {

        int x[] = { 2, 6, 1, 3, 5, 7, 4 };
        QuickSort.sort(x, 0, x.length - 1);

        int array[] = { 10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11 };

        System.out.println("User entered Array: ");
        QuickSort.printArray(array);

        QuickSort.sort(array, 0, array.length - 1);

        System.out.println("\n\nAfter sorting: ");
        QuickSort.printArray(array);
    }// end of method

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            sort(array, start, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
        }
    }

    static int partition(int[] array, int startIndex, int endIndex) {
        int pivotElement = array[endIndex];
        int i = startIndex-1;
        for (int j = startIndex; j <= endIndex; j++) {
            int element = array[j];
            if (element <= pivotElement) {
                i++;
                swap(array, i, j);
            }
        }
        return i;

    }// end of method

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }// end of method

}// end of class
