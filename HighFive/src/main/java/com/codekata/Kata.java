package com.codekata;

import static com.codekata.PrintUtil.printHorizontal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kata {

  /**
   * Given a list of  [[id,score]..N] return the top 5 average [[id,average]..N] for each ID.
   */
  public static int[][] sortingApproach(int[][] items) {

    //[a] Sort the items by ID increasing and Score decreasing.
    //[b] Sum the first 5 Scores for the ID and divide by 5.
    //[c] Create a result [id, average] and store it into a list.
    //[d] Jump to the next ID and repeat the process.
    //[e] Convert the list of arrays into an multi-dimensional array

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


}
