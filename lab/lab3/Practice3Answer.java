package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Practice3Answer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please input the function No:\n" +
                    "1 - Get even numbers\n" +
                    "2 - Get odd numbers\n" +
                    "3 - Get prime numbers\n" +
                    "4 - Get prime numbers that are bigger than 5" +
                    "\n0 - Quit");
            int x = input.nextInt();
            if (x == 0) {
                break;
            }
            ArrayList<Integer> nums = new ArrayList<>();
            System.out.println("Input size of the list:");
            int size = input.nextInt();
            System.out.println("Input elements of the list:");
            for (int i = 0; i < size; i++) {
                nums.add(input.nextInt());
            }
            if (x == 1) {
                eval(nums, n -> n % 2 != 0);
            } else if (x == 2) {
                eval(nums, n -> n % 2 == 0);
            } else if (x == 3) {
                eval(nums, n -> {
                    for (int i = 2; i < n; i++) {
                        if (n % i == 0) {
                            return false;
                        }
                    }
                    return true;
                });
            } else if (x == 4) {
                eval(nums, n -> {
                    for (int i = 2; i < n; i++) {
                        if (n % i == 0) {
                            return false;
                        }
                    }
                    return n > 5;
                });
            }
        }
    }

    public static void eval(List<Integer> nums, Predicate<Integer> predicate) {
        ArrayList<Integer> array = new ArrayList<>();
        for (Integer n : nums) {
            if (predicate.test(n)) {
                array.add(n);
            }
        }
        System.out.println(array);
    }
}
