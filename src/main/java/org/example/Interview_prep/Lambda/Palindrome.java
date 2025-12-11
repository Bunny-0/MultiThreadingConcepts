package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Palindrome {


    public static void main(String[] args) {

        List<String> palindromeNames = Arrays.asList("Telugu", "Tamil",
                "Malayalam");
        List<String> findPalindromeStrings = palindromeNames
                .stream()
                .filter(s -> {
                    return s.toLowerCase()
                            .contentEquals(new
                                    StringBuilder(s.toLowerCase()).reverse());
                }).toList();
        System.out.println(findPalindromeStrings);

        List<String> words = Arrays.asList("cat", "elephant", "dogfffghyjk", "giraffe", "zebra");
        String longestWord = words.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(longestWord);

    }
}
