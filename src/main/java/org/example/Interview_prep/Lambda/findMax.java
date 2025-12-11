package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class findMax {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 41, 4);

        int max=numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);


        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95,
                14, 56, 87);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> topThree = listOfIntegers.stream().filter(pq::add).collect(Collectors.toUnmodifiableList());
        System.out.println(pq.poll()+" "+pq.poll()+" "+pq.poll());

        List<Integer> topThree1 = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(topThree1);

        List<Integer> listOfIntegers2 = Arrays.asList(71, 18, 42, 21, 67, 32, 95,
                14, 56, 87);

        List<Integer> thirdHighest = listOfIntegers2
                .stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).collect(Collectors.toUnmodifiableList());
        System.out.println(thirdHighest);
    }
}
