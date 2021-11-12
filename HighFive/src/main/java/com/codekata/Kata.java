package com.codekata;

import static com.codekata.PrintUtil.printHorizontal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Kata {

  /*
  //[a] Sort the items by ID increasing and Score decreasing.
  //[b] Sum the first 5 Scores for the ID and divide by 5.
  //[c] Create a result [id, average] and store it into a list.
  //[d] Jump to the next ID and repeat the process.
  //[e] Convert the list of arrays into an multi-dimensional array
  */
  public static int[][] sortingApproach(int[][] items) {
    //[a] Sort the items by ID increasing and Score decreasing.
    Arrays.sort(items, (a1, a2) -> {
      if (a1[0] != a2[0]) {
        return a1[0] - a2[0];
      }
      return a2[1] - a1[1];
    });

    //[b] Sum the first 5 Scores for the ID and divide by 5.
    int n = 0;
    int l = items.length;
    List<int[]> resultList = new ArrayList<>();
    while (n < l) {
      int sum = 0;
      for (int i = n; i < n + 5; i++) {
        sum += items[i][1];
      }
      //[c] Create a result [id, average] and store it into a list.
      int id = items[n][0];
      int result[] = new int[]{id, sum / 5};
      resultList.add(result);
      //[d] Jump to the next ID
      while (n < l && id == items[n][0]) {
        n++;
      }
    }
    //[e] Convert the list of arrays into an multi-dimensional array
    return resultList.toArray(new int[resultList.size()][]);
  }

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
      int[] result = new int[]{id, average};
      resultList.add(result);
    }
    //[e] Convert the list of arrays into an multi-dimensional array and return
    return resultList.toArray(new int[resultList.size()][]);
  }


}
