package by.gsu.pms;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;


public class ThreadGenerator {




    public static void main(String[] args) {
        int threadsCount = 0;
        String operation = "";
        int upperBorder = 0;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Threads count: ");
            threadsCount = scan.nextInt();
            System.out.println("Operation (Supported only +,-,*):");
            operation = scan.next();
            System.out.println("Max value: ");
            upperBorder = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Try to reboot your PC");
            exit(1);
        }




        CalculatorThread calculator = new CalculatorThread();
        List<Integer> result = calculator.startInRange(threadsCount,upperBorder);

        System.out.println(result);

        switch (operation) {
            case "+" -> plus(result);
            case "-" -> minus(result);
            case "*" -> multiply(result);
            default -> System.out.println("wrong operation");
        }
    }

    public static void plus(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    public static void minus(List<Integer> numbers) {
        int sum = numbers.get(0);
        for (int i = 1;i<numbers.size();i++) {
            sum -= numbers.get(i);
        }
        System.out.println(sum);
    }

    public static void multiply(List<Integer> numbers) {
        int sum = numbers.get(0);
        for (int i = 1;i<numbers.size();i++) {
            sum *= numbers.get(i);
        }
        System.out.println(sum);
    }




}
