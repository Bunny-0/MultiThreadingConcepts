package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {



    public static void main(String[] args) {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
        Set<Integer> set=new HashSet<>();
//        List<Integer> data=duplicateNumbers.stream().filter(set::add).collect(Collectors.toList());
        List<Integer> data=duplicateNumbers.stream().filter(i->!(set.add(i))).collect(Collectors.toUnmodifiableList());
        System.out.println(data.toString());


    }
}
