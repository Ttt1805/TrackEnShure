package homework.lesson9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMain {
    static final String REGEXP = "\\W+"; // for splitting into words


    public static void task12(){
         try ( BufferedReader reader = new BufferedReader(new FileReader("SonnetI.txt"))) {
             List<String> list = reader.lines()
                     .flatMap(s -> Stream.of(s.split(REGEXP)))
                     .filter(s -> !s.isEmpty())
       //              .sorted(Comparator.naturalOrder()
        //                     .thenComparing(Comparator.comparingInt(String::length).
       //                              Comparator.comparingInt(String::length)))
                     .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                     .collect(Collectors.toList());
             Map<String, Map<Integer, List<String>>> map = new TreeMap<>();
             for (String s: list) {
                 String first = s.substring(0, 1);
                 int len = s.length();
                 Map<Integer, List<String>> el1;
                 List<String> el2 = new ArrayList<>();
                 Map<Integer, List<String>> map2 = new TreeMap<>();
                 if (Objects.isNull(map.get(first))) {

                     el2.add(s);
                     map2.put(len, el2);
                     map.put(first, map2);

                 } else {
                     el1 = map.get(first);
                     if (Objects.isNull(el1.get(len))){
                         el2.add(s);
                         el1.put(len,el2);
                     }
                     else {
                        el2 = el1.get(len);
                        el2.add(s);
                     }
                 }
             }
             System.out.println(map);
         } catch (IOException e) {
             e.printStackTrace();
         }


    }
    public static void main(String[] args) {
        task12();

    }
}
