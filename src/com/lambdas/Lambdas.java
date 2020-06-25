package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nayan.kakati on 3/27/18.
 */
public class Lambdas {
	public static void main(String...args) {
		Employee john = new Employee("john doe",30);
		Employee tim = new Employee("tim", 21);
		Employee jack = new Employee("jack", 40);
		Employee snow = new Employee("snow", 22);

		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(tim);
		employees.add(jack);
		employees.add(snow);

		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
		for (Employee emp :employees) {
			System.out.println(emp.getName());
		}

		// traditiional way
		String tradsilly = doStringStuff(new UpperConcat() {
			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() + " " + s2.toUpperCase();
			}
		}, employees.get(0).getName(),employees.get(1).getName());
		System.out.println(tradsilly);

		// lambda way
		UpperConcat uc = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
		String lambSilly = doStringStuff(uc,employees.get(0).getName(), employees.get(1).getName());
		System.out.println(lambSilly);

		AnotherClass anotherClass = new AnotherClass();
		String res = anotherClass.doSomthing();
		System.out.println(res);
	}
	public final static String doStringStuff(UpperConcat uc, String s1, String s2){
		return uc.upperAndConcat(s1,s2);
	}
}

 class Employee {
	private String name;
	private int age;

	 public Employee(String name, int age) {
		 this.name = name;
		 this.age = age;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public int getAge() {
		 return age;
	 }

	 public void setAge(int age) {
		 this.age = age;
	 }
 }

 interface UpperConcat {
	String upperAndConcat(String s1, String s2);
 }

 class AnotherClass {

	public String doSomthing() {
		int i =0;
		// i++; cannot do an increment and this scope as the value that would be used in lambda might get different.
		System.out.println("The anotherClass name is :" + getClass().getSimpleName());

		return Lambdas.doStringStuff(((s1, s2) -> {
			System.out.println("Anonymous class is :" + getClass().getSimpleName());
			System.out.println("value of i  is: " + i);
			return  s1.toUpperCase() + s2.toUpperCase();
		}), "a", "b");
	}

	public void printValue() {
		int number = 25;

		Runnable r = () -> {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("value of number is :" + number);
		};

		new Thread(r).start();
	}
 }
