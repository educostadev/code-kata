package problems.sort;

/**
 * Boa explicação: https://www.geeksforgeeks.org/insertion-sort/
 * 
 * Insertion sort is a simple sorting algorithm that works the way we sort
 * playing cards in our hands.
 * 
 * O array é dividido em lado esquerdo (ordenado) e lado direito (desordenado) pega-se o primeiro item do lado direito
 * faz-se o shift de todos os elementos do lado esquerdo e coloca o item do lado direito na posição correta no lado esquerdo.
 * 
 */
public class InsertionSort {
    public static void main(String[] args) {

        InsertionSort.sort(new int[] { 10, 3, 2, 1 });

        int array[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };

        System.out.println("User entered Array: ");
        InsertionSort.printArray(array);

        long start = System.nanoTime();
        InsertionSort.sort(array);
        long end = System.nanoTime();
        System.out.println("\n\nTime to execute this algo: " + (end - start));

        System.out.println("\nAfter sorting: ");
        InsertionSort.printArray(array);
    }// end of method

    static void sort(int[] array) {
        for (int unsortedArrayIndex = 1; unsortedArrayIndex < array.length; unsortedArrayIndex++) {
            int firstUnsortedElement = array[unsortedArrayIndex];
            int sortedArrayIndex = unsortedArrayIndex;
            while (sortedArrayIndex > 0 && array[sortedArrayIndex - 1] > firstUnsortedElement) {
                array[sortedArrayIndex] = array[sortedArrayIndex - 1];
                sortedArrayIndex--;
            }
            array[sortedArrayIndex] = firstUnsortedElement;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }// end of method

}// end of class