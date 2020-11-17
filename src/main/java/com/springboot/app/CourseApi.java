package com.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@SpringBootApplication
public class CourseApi {

    public static <K, V> TreeMap<K, V> convertToTreeMap(Hashtable<K, V> ht)
    {

        // Return the TreeMap
        return ht
        // Get the entries from the hashMap
        .entrySet()
        // Convert the map into stream
        .stream()
        // Now collect the returned TreeMap
        .collect(
                Collectors
                        // Using Collectors, collect the entries
                        // and convert it into TreeMap
                        .toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue,
                                 newValue)
                                        -> newValue,
                                TreeMap::new));
    }

    public static void main(String[] args) {
//        SpringApplication.run(CourseApi.class, args);
        Hashtable<Object,Object> ht = System.getProperties();
        TreeMap<Object, Object> tm = convertToTreeMap(ht);

        int a = 3;
        System.out.println(a + "\n");
        System.out.println(System.getProperty("user.dir") + "\n");

        for(Map.Entry<Object, Object> entry : tm.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println(key + " => " + value);
        }
    }
}
