package org.example.Interview_prep.Lambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

    public static void main(String[] args) {

        String s1 = "RaceCar";
        String s2 = "CarRace";

        String data1=Stream.of(s1.toLowerCase().split("")).sorted().collect(Collectors.joining());
        String data2=Stream.of(s2.toLowerCase().split("")).sorted().collect(Collectors.joining());
        System.out.println(data1.equals(data2));
    }
}
