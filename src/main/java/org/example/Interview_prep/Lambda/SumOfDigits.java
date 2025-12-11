package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfDigits {

    public static void main(String[] args) {

        int i = 15623;
        Integer sumOfDigits = Arrays.stream(String.valueOf(i).split(""))
                .collect(Collectors
                        .summingInt(Integer::parseInt));

        System.out.println(sumOfDigits);

        String str = "Java Concept Of The Day";

        String reversed=Arrays.stream(str.split(" ")).map(temp->new StringBuilder(temp).reverse()).collect(Collectors.joining(" "));
        System.out.println(reversed);

        List<String> strings = Arrays.asList("java scala ruby", "java react spring java");
                String word = "java";
                long count=strings.stream().flatMap(s->Arrays.stream(s.split(" "))).filter(s->s.equals(word)).count();
                System.out.println(count);
    }
}
