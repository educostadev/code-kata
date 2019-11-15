package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class FindDuplicate {
    public static void main(String args[]) {
        int[] anArray = { 1, 2, 3, 4, 3, 1, 7, 2, 9, 1 };

        Arrays.stream(anArray).boxed().collect(Collectors.groupingBy(Integer::intValue)).values().stream()
                .filter(l -> l.size() > 1).forEach(numbers -> System.out.println(numbers.get(0)));

    }
}