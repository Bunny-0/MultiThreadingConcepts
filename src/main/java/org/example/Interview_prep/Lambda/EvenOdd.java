package org.example.Interview_prep.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EvenOdd {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        boolean res=numbers.stream().filter(data->data%2==1).findAny().isPresent();
        boolean res1=numbers.stream().allMatch(data->data%2==0);
        System.out.println(res1);
        List<String> nameList = Arrays.asList("Banana", "Apple", "Cat", "Andrew");
        boolean data=nameList.stream().anyMatch(temp->temp.startsWith("A"));
        System.out.println(data);
        List<Integer> numbers1 = Arrays.asList(10, 12, 20, 19,null, 30);
       List<Integer> startWith1=numbers1.stream().filter(temp-> temp==null?false : temp.toString().charAt(0)=='1').collect(Collectors.toUnmodifiableList());
        System.out.println(startWith1);

        List<Integer> list = Arrays.asList(15,8,49,25,98,32);
        Optional<Integer> num=list.stream().filter(temp->temp%2==0).findFirst();
        System.out.println(num);
    }
}
