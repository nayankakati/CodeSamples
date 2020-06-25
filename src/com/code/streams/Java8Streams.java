package code.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Streams {

    public static void main(String[] args) {
       Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };


        //Stream.of("zebra","apple","mango").sorted().findFirst().ifPresent(System.out::println);
        //List<String> d = Stream.of("zebra","apple","mango").sorted().collect(Collectors.toList());
        //System.out.println(d);

        String[] s = {"qwerty","ashiq","apPle","Ananas","boys","cool"};

        //Arrays.stream(s).filter(x -> x.startsWith("a")).sorted().forEach(System.out::println);

        //Arrays.stream(s).map(String::toLowerCase).filter(x -> x.startsWith("a")).sorted().forEach(System.out::println);

        List<String> awe = new ArrayList<>();
        awe.add("Smoothi,-chocklate,creame");
        awe.add("suthie,rahi,mji");

       // Map<String, String> msp = awe.stream().map(x -> x.split(",")).collect(Collectors.toMap(x -> x[0], x -> x[1]));
       // System.out.println(msp);

        List<String> transactions = new ArrayList<>();
        transactions.add("nayan,700");
        transactions.add("nayan,700");
        transactions.add("nayan,6000");
        transactions.add("nayan,7000");
        transactions.add("nayan,708");

        transactions.contains("nayan");

        System.out.println(findRejectedTransactions(transactions, 7000));


    }

    static Object[] remove(Object[] objects, int[] columns) {
        List<Object> list = new ArrayList<>(Arrays.asList(objects));

        int removed = 0;

        for (int i : columns)  {
            list.remove(i - removed++);
        }

        return list.toArray();
    }


    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {

        Map<String, Integer> customerToValue = new HashMap<>();
        List<String> rejectedTransactions = new ArrayList<>();

        transactions.stream().forEachOrdered( transact -> {
                        String[] transactionArr =  transact.split(",");
                        int tempValue = Integer.parseInt(transactionArr[1]);
                        String customer = transactionArr[0];

                        if(transactionArr.length == 2 && customerToValue.containsKey(customer)) {
                             tempValue += customerToValue.get(customer);
                        }

                        if(tempValue > creditLimit) {
                            rejectedTransactions.add(transact);
                         } else {
                            customerToValue.put(customer, tempValue);
                        }
                }
        );

        return rejectedTransactions;
    }
        static class Employee {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
