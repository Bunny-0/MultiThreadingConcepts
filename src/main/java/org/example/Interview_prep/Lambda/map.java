package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class map {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> data=list.stream().map(temp->temp*temp*temp).filter(temp->temp>2850).collect(Collectors.toUnmodifiableList());
        System.out.println(data);

    }
}
