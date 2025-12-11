package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(11, 11, 1, 3, 5, 6, 5);

//        List<Integer> data=list.stream().sorted().collect(Collectors.toUnmodifiableList());
        List<Integer> data=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toUnmodifiableList());
        System.out.println(data.toString());

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL",
                "C");
        List<String> data1=listOfStrings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toUnmodifiableList());
        System.out.println(data1.toString());


        int[] a = new int[] { 4, 2, 7, 1 };
        int[] b = new int[] { 8, 3, 9, 5 };
        int[] c = Stream.concat(Arrays.stream(a).boxed(),Arrays.stream(b).boxed()).sorted().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(c));
    }
}
