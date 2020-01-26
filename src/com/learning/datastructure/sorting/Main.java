package com.learning.datastructure.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    private static boolean quit = false;

    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        try (Scanner scanner = new Scanner(System.in))
        {
            while (!quit)
            {
                showMenu();
                int[] cloneArray = Arrays.copyOf(intArray, intArray.length);

                if (!processCommand(scanner, cloneArray))
                {
                    continue;
                }

                print(cloneArray);
            }
        }
    }


    private static void shellSort(int[] intArray)
    {
        for (int gap = intArray.length / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < intArray.length; i++)
            {
                int newElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > newElement)
                {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }
    }

    private static void insertionSort(int[] intArray)
    {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
        {
            int newElement = intArray[firstUnsortedIndex];
            int i;

            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--)
            {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
    }

    private static void selectionSort(int[] intArray)
    {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
        {
            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++)
            {
                if (intArray[i] > intArray[largest])
                {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }
    }

    private static void bubbleSort(int[] intArray)
    {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
        {
            for (int i = 0; i < lastUnsortedIndex; i++)
            {
                if (intArray[i] > intArray[i + 1])
                {
                    swap(intArray, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j)
    {
        if (i == j)
        {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static void showMenu()
    {
        System.out.println();
        System.out.println("=====================");
        System.out.println("Welcome to Data Sorting");
        System.out.println("=====================");
        System.out.println("q to quit.");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Shell Sort");
        System.out.println("=====================");
        System.out.println("Choose an option:");
    }

    private static boolean processCommand(Scanner scanner, int[] intArray)
    {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("q"))
        {
            quit = true;
            System.out.println("Goodbye");
            return false;
        }
        long timeStart = System.nanoTime();
        switch (input)
        {
            case "1":
                System.out.println("Bubble Sort");
                bubbleSort(intArray);
                break;
            case "2":
                System.out.println("Selection Sort");
                selectionSort(intArray);
                break;
            case "3":
                System.out.println("Insertion Sort");
                insertionSort(intArray);
                break;
            case "4":
                System.out.println("Shell Sort");
                shellSort(intArray);
                break;

            default:
                System.out.println("Invalid input.");
                return false;

        }
        long timeEnd = System.nanoTime();
        System.out.println("Time taken for sorting: " + (timeEnd-timeStart) +"ns");
        return true;
    }

    private static void print(int[] intArray)
    {
        System.out.println("Sorting Result: ");
        for (int i = 0; i < intArray.length; i++)
        {
            System.out.print((intArray[i]) + " ");
        }
        System.out.println();
    }
}


