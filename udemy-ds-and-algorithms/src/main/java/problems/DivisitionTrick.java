package problems;

/**
 * Write a function to perform integer division without using either the / or *
 * http://www.algorist.com/algowiki/index.php/TADM2E_1.28
 */
class DivisionTrick {
    public static void main(String[] args) {
        System.out.println(division(10, 5));
    }

    static int division(int numerator, int denominator) {
        int quotiente = 0;
        while (numerator >= denominator) {
            numerator -= denominator;
            quotiente++;
        }
        return quotiente;
    }
}