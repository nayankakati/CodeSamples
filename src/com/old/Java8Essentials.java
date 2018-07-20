package com.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by nayan.kakati on 10/19/17.
 */
public class Java8Essentials {

	public static void main(String...args) {


		// Type 1
		List<String> names = Arrays.asList("hi", "hello", "karuku");

		List<String> filteredList = names.stream().filter(name -> !name.equals("karuku")).collect(Collectors.toList());

		//filteredList.forEach(System.out::println);

		//Type 2
		List<Person> persons = Arrays.asList(
			new Person("mkyong", 30),
			new Person("lawrence", 40),
			new Person("jack", 20),
			new Person("jack", 30)
		);


		Person result = persons.parallelStream().filter(name -> (name.getName().equals("jack") && name.getAge() == 20)).findAny().orElse(new Person("I am New", 50));
		///System.out.println(result);

		//Type 3 Mp only names
		List<String> onlyNames = persons.stream().map(Person::getName).collect(Collectors.toList());
		//onlyNames.forEach(System.out::println);

		//variant
		HashSet<String> onlyHash = persons.stream().map(Person::getName).collect(Collectors.toCollection(HashSet::new));

		//onlyHash.forEach(System.out::println);
		//Type 4 Map get all keys
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		//items.forEach((k,v) -> System.out.println(k +","+v));

		//Type 5
		List<String> items1 = new ArrayList<String>();
		items1.add("A");
		items1.add("B");
		items1.add("C");
		items1.add("D");
		items1.add("E");

//lambda
//Output : A,B,C,D,E
		items1.forEach(item->System.out.println(""));

//Output : C
		items1.forEach(item->{
			if("C".equals(item)){
				//System.out.println(item);
			}
		});

		// Type 6 {Parallel and non-parallel not from beginning}
		List<Person> parNonPar = persons.stream().parallel().filter(person -> person.getAge() > 20).sequential().collect(Collectors.toList());
		parNonPar.forEach(System.out::println);
	}
}
