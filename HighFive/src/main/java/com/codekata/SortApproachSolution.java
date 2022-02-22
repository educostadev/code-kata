package com.codekata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortApproachSolution implements Solution {

  /**
   * [a] Ordene a lista de notas por ID crescente e notas decrescente.
   * <p>
   * [b] Some as 5 primeiras notas para o ID e divida por 5 para obter a média.
   * <p>
   * [c] Armazene o resultado em um array com ID e média e guarde em uma lista de arrays.
   * <p>
   * [d] Localize o proximo ID da lista saltando todas a proximas notas e repita o processo.
   * <p>
   * [e] Percorrido toda a lista, converta a lista com os resultados em um array multi-dimensional e retorne.
   */
  @Override
  public int[][] solve(int[][] items) {

    //[a] Ordene a lista de notas por ID crescente e notas decrescente.
    Arrays.sort(items, (a, b) -> {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return b[1] - a[1];
    });

    //[b] Some as 5 primeiras notas para o ID e divida por 5 para obter a média.
    int n = 0;
    int l = items.length;
    List<int[]> resultList = new ArrayList<>();
    while (n < l) {
      int sum = 0;
      for (int i = n; i < n + 5; i++) {
        sum += items[i][1];
      }
      //[c] Armazene o resultado em um array com ID e média e guarde em uma lista de arrays..
      int id = items[n][0];
      int[] result = new int[] {id, sum / 5};
      resultList.add(result);
      //[d] Localize o proximo ID da lista saltando todas a proximas notas e repita o processo.
      while (n < l && id == items[n][0]) {
        n++;
      }
    }
    //[e] Percorrido toda a lista, converta a lista com os resultados em um array multi-dimensional e retorne.
    return resultList.toArray(new int[resultList.size()][]);
  }
}
