package com.codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Kata implements Solution {


  /*
   //Keep a Max Heap of all the Scores for every id. The first 5 elements will be the top 5 score. Use a Ordered Map to group the Max Heap by ID and keep the ID ordered.
   //[a] Iterate over all itens and Initialize the Ordered Map with the Max Heap PriorityQueue for that ID.
   //[b] Add the Score into the PriorityQueue for that ID
   //[c] Iterate over all Map keys and sum the first 5 element from the PriorityQueue
   //[d] Create a result [id, average] and store it into a list.
   //[e] Convert the list of arrays into an multi-dimensional array and return
   */
  public static int[][] maxHeapApproach(int[][] items) {
    Map<Integer, Queue<Integer>> map = new TreeMap<>();
    //[a] Iterate over all item...
    for (int[] item : items) {
      int id = item[0];
      if (!map.containsKey(id)) {
        //...and Initialize the Ordered Map with the Map Heap PriorityQueue for that ID
        map.put(id, new PriorityQueue<>((a, b) -> b - a));
      }
      //[b] Add the Score into the PriorityQueue for that ID
      int score = item[1];
      map.get(id).add(score);
    }
    List<int[]> resultList = new ArrayList<>();
    //[c] Iterate over all Map keys...
    for (int id : map.keySet()) {
      //...and sum the first 5 element from the PriorityQueue
      int sum = 0;
      for (int i = 0; i < 5; i++) {
        sum += map.get(id).poll();
      }
      //[d] Create a result [id, average] and store it into a list.
      int average = sum / 5;
      int[] result = new int[] {id, average};
      resultList.add(result);
    }
    //[e] Convert the list of arrays into an multi-dimensional array and return
    return resultList.toArray(new int[resultList.size()][]);
  }


  @Override
  public int[][] solve(int[][] input) {
    int[][] result = maxHeapApproach(input);
    //int[][] result = sortingApproach(input);
    this.printHorizontal(result);
    return result;

  }

}
