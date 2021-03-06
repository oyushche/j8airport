package com.luxoft.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class S9_Collectors_3
{
    public static void main(String[] args)
    {
        List<Person> people = getPersonList();

        Map<Integer, List<Person>> result = people
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(result);
    }

    public static List<Person> getPersonList()
    {
        int[] ages = {23, 18, 37, 18, 23};
        String[] names = {"Oleg", "Anna", "Irina", "Ivan", "Alexey"};

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < names.length; i++)
        {
            Person p = new Person();

            p.setName(names[i]);
            p.setAge(ages[i]);

            people.add(p);
        }

        return people;
    }
}
