package com.codekata;

import com.codekata.util.Node;
import com.codekata.util.PrintTree;

import lombok.Builder;
import lombok.ToString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KataTest {

    static int execution;

    /**
     * @return Return a Stream of Argument to be tested.
     *         Arguments.of(<DATA_INPUT>,<ALGORITHM>)
     */
    private static Stream<Arguments> readInput() {

        var dataInput1 = DataInput.builder()
                .input(new Integer[] { 3, 9, 20, null, null, 15, 7 })
                .expected(2)
                .treeType(Node.Type.COMPLETE_BINARY_TREE)
                .build();

        var dataInput2 = DataInput.builder()
                .input(new Integer[] { 2, null, 3, null, 4, null, 5, null, 6 })
                .expected(5)
                .treeType(Node.Type.LEFT_SKEWED_BINARY_TREE)
                .build();

        return Stream.of(
                Arguments.of(dataInput1, new BFSQueueApproach()),
                Arguments.of(dataInput1, new DFSRecursiveApproach()),
                Arguments.of(dataInput1, new DFSStackApproach()),

                Arguments.of(dataInput2, new BFSQueueApproach()),
                Arguments.of(dataInput2, new DFSRecursiveApproach()),
                Arguments.of(dataInput2, new DFSStackApproach())                
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
    void solveTheProblem(DataInput data, Solution algorithm) {
        Node<Integer> root = new Node<Integer>().toTree(data.input, data.treeType);
        System.out.println("Execution Nr [" + (++execution) + "]");
        PrintTree.vertical(root);
        System.out.println("\n");
        Assertions.assertEquals(data.expected, algorithm.solve(root));
    }

    protected static Stream<Arguments> createInputUsingNode() {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.right.right = new Node<>(7);
        root.right = new Node<>(3);
        root.right.right = new Node<>(6);

        var dataInput1 = DataInputWithNode.builder()
        .input(root)
        .expected(3)
        .build();

        return Stream.of(
                    Arguments.of(dataInput1, new BFSQueueApproach()),
                    Arguments.of(dataInput1, new DFSRecursiveApproach()),
                    Arguments.of(dataInput1, new DFSStackApproach())
                );
    }

    @ParameterizedTest
    @MethodSource("createInputUsingNode")
    void solveTheProblemWithNode(DataInputWithNode data, Solution algorithm) {
        System.out.println("Execution Nr [" + (++execution) + "]");
        PrintTree.vertical(data.input);
        System.out.println("\n");
        Assertions.assertEquals(data.expected, algorithm.solve(data.input));
    }

    @Builder
    @ToString
    static class DataInput {
        Integer[] input;
        int expected;
        Node.Type treeType;
    }

    @Builder
    @ToString
    static class DataInputWithNode {
        Node<Integer> input;
        int expected;
    }

}
