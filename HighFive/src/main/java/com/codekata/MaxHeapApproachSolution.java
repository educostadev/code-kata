package com.codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * [a] Crie um TreeMap cujo a key seja o ID e o value uma Queue de notas. As keys se manterá ordenada e no value deve ser usado um PriorityQueue para os valores
 * ficar ordenados de forma decrescente.
 * <p>
 * [b] Percorra toda a lista e adicione cada nota na Queue do respectivo ID.
 * <p>
 * [c] Percorra todas a keys e some os 5 primeiro elementos da Queue associada a ela e guarde o resultado em uma lista
 * <p>
 * [d] Converta a lista com os resultado em um array multidimensional e retorne
 */
public class MaxHeapApproachSolution implements Solution {


  @Override
  public int[][] solve(int[][] items) {

    //[a] Crie um TreeMap cujo a key seja o ID e o value uma Queue de notas. As keys se manterá ordenada e no value deve ser usado um PriorityQueue para os valores ficar ordenados de forma decrescente.
    TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();

    //[b] Percorra toda a lista e adicione cada nota na Queue do respectivo ID.
    Arrays.stream(items).forEach(item -> {
      map.computeIfAbsent(item[0], x -> new PriorityQueue<>((a, b) -> b - a)).add(item[1]);
    });

    //[c] Percorra todas a keys e some os 5 primeiro elementos da Queue associada a ela e guarde o resultado em uma lista
    List<int[]> results = new ArrayList<>();
    map.forEach((id, scores) -> {
      var sum = IntStream.range(0, 5).map(i -> scores.poll()).reduce(0, (a, b) -> a + b);
      results.add(new int[] {id, sum / 5});
    });

    //[d] Converta a lista com os resultado em um array multidimensional e retorne
    return results.toArray(new int[results.size()][]);
  }


}

