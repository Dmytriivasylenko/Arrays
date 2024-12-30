package app;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // array with 15 elements
        int[] array = new int[15];
        Random random = new Random();

        // random
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        System.out.println("Initial array: " + Arrays.toString(array));

        // Sorting
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        // sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));

        // input a number to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("input a number to search: ");
        int key = scanner.nextInt();

        // Binary search
        int low = 0;
        int high = array.length - 1;
        int idx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == key) {
                idx = mid;
                break;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println((idx == -1) ? ("Number " + key + " is not in the array.") : ("Number " + key + " is at index " + idx));
    }
}
