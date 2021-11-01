package com.example.concurrentlearn.test;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wangyu
 * @Date: Created 2020-09-14 13:47
 * @Description:
 * @Modified By:
 */
public class StreamTest {

    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> x > 185;
        Student student = Student.builder()
                .name("9龙")
                .age(23)
                .height(175)
                .build();
        /** predicate test */
        System.out.println("9龙的身高高于185吗？：" + predicate.test(student.getHeight()));


        Consumer<String> consumer = System.out::println;
        consumer.accept("命运由我不由天");

        Function<Student, String> function = Student::getName;
        String apply = function.apply(student);
        System.out.println(apply);

        List<Student> collect = Stream.of(Student.builder().name("lily").age(23).height(166).build(),
                Student.builder().name("nacy").age(24).height(174).build())
                .collect(Collectors.toList());
        //filter -> predicate
        List<Student> collect1 = collect.stream().filter(s -> s.getHeight() < 180).collect(Collectors.toList());

        //map -> function  转换
        List<String> names = collect.stream().map(t -> t.getName()).collect(Collectors.toList());



        duplicateRemove();
    }


    public static void duplicateRemove(){

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(3);

        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);


    }







}
