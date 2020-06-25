package lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayan.kakati on 4/23/18.
 */
public class Functional {

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

		//employees.forEach(employee -> System.out.println(employee.getAge()));

		employees.stream().map(s -> s.getName().toUpperCase()).filter(f -> f.equalsIgnoreCase("tim")).forEach(s -> System.out.println(s));
		}

}
