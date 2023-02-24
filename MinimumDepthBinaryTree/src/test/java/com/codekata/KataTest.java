package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.PrintTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


abstract class KataTest {

    /**
     * @return Return a Stream of Argument to be tested. Arguments.of(<INPUT>,<EXPECTED>)
     */
    private static Stream<Arguments> readInput() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        2,
                        Node.Type.COMPLETE_BINARY_TREE
                ),
                Arguments.of(
                        new Integer[]{2, null, 3, null, 4, null, 5, null, 6},
                        5,
                        Node.Type.LEFT_SKEWED_BINARY_TREE
                )
        );
    }

    /**
     * Adjust the method signature type according to the INPUT and EXPECTED result.
     *
     * @param input    - The input that should be tested.
     * @param expected - The expected result.
     */
    @ParameterizedTest
    @MethodSource("readInput")
    void solveTheProblem(Integer[] input, int expected, Node.Type treeType) {
        Solution solution = createSolution();
        Node<Integer> root = new Node<Integer>().toTree(input,treeType);
        PrintTree.vertical(root);
        Assertions.assertEquals(expected, solution.solve(root));
    }

    abstract Solution createSolution();
}
