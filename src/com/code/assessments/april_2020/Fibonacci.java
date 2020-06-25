package code.assessments.april_2020;

public class Fibonacci {

    public static void main(String[] args) {
        int tillfib = 20;

        int first = 0;
        int second = 1;
        int previous1 = first;
        int previous2 = second;
        int next = 0;

        System.out.print(first + " ");
        System.out.print(second + " ");

        for (int i=0; i< tillfib ;i ++) {
            next = previous1 + previous2;
            previous1 = previous2;
            previous2 = next;
            System.out.print(next + " ");
        }
    }
}
