package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{37, 1, 12}, {95, 38, 47}, {3, 10, 17}};
        List<Integer> list = Arrays.stream(matrix).
                flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list);
    }
}
