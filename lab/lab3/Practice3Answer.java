package lab.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            List<Integer> nums = new ArrayList<>();
            System.out.println("Input size of the list:");
            int size = input.nextInt();
            System.out.println("Input elements of the list:");
            for (int i = 0; i < size; i++) {
                nums.add(input.nextInt());
            }
            if (x == 1) {
                nums = nums.stream().filter(o -> o % 2 == 0).collect(Collectors.toList());
            } else if (x == 2) {
                nums = nums.stream().filter(o -> o % 2 == 1).collect(Collectors.toList());
            } else if (x == 3) {
                nums = nums.stream().filter(o -> isPrime(o)).collect(Collectors.toList());
            }
            else if (x == 4){
                nums = nums.stream().filter(o -> isPrime(o) && o > 5).collect(Collectors.toList());
            }
            System.out.println(nums);
        }
    }

    public static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
