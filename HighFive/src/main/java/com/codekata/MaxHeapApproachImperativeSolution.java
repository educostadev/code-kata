package com.codekata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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
public class MaxHeapApproachImperativeSolution implements Solution {


  @Override
  public int[][] solve(int[][] items) {
    Map<Integer, Queue<Integer>> map = new TreeMap<>();
    //[a] Crie um TreeMap cujo a key seja o ID e o value uma Queue de notas. As keys se manterá ordenada e no value deve ser usado um PriorityQueue para os valores ficar ordenados de forma decrescente.
    for (int[] item : items) {
      int id = item[0];
      if (!map.containsKey(id)) {
        map.put(id, new PriorityQueue<>((a, b) -> b - a));
      }
      //[b] Percorra toda a lista e adicione cada nota na Queue do respectivo ID.
      int score = item[1];
      map.get(id).add(score);
    }

    List<int[]> resultList = new ArrayList<>();
    //[c] Percorra todas a keys e some os 5 primeiro elementos da Queue associada a ela e guarde o resultado em uma lista
    for (int id : map.keySet()) {
      int sum = 0;
      for (int i = 0; i < 5; i++) {
        sum += map.get(id).poll();
      }

      int average = sum / 5;
      int[] result = new int[] {id, average};
      resultList.add(result);
    }

    //[d] Converta a lista com os resultado em um array multidimensional e retorne
    return resultList.toArray(new int[resultList.size()][]);
  }


}

