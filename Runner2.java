/*
Author: Edgar E. Rodriguez
TAs: Anthony M Ortiz Cepeda and Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 11/10/16
Goals: Read the widht, height, and length of packages from file, and calculate the following:
*/

import java.util.*;
import java.io.*;

public class Runner2 {

    public static Box[] generateRandomBoxes (int arraySize) {
        Box[] generatedBoxArray = new Box[arraySize];

        for (int i = 0; i < arraySize; i++) {
            generatedBoxArray[i] = new Box( (1 + (Math.random()*99)), (1 + (Math.random()*99)), (1 + (Math.random()*99)) );
        }
        return generatedBoxArray;
    }

    public static Box[] CopyArray (Box[] anArray) {
        Box[] copiedArray = new Box[anArray.length];

        for (int i = 0; i < anArray.length; i++) {
            copiedArray[i] = new Box( anArray[i].length, anArray[i].width, anArray[i].height );
        }
        return copiedArray;
    }

    public static void insertionSort(Box[] anArray) {
        for (int i = 1; i < anArray.length; i++) {
            /** Insert anArray[i] into a sorted sublist anArray[0..i-1] so that anArray[0..i] is sorted. */
            Box currentElement = anArray[i];
            double currentElementVolume = anArray[i].getVolume();
            int k;
            for (k = i - 1; k >= 0 && anArray[k].getVolume() > currentElementVolume; k--) {
                anArray[k + 1] = anArray[k];
            }

            // Insert the current element into anArray[k + 1]
            anArray[k + 1] = currentElement;
        }
    }

    /** The method for sorting the numbers */
    public static void mergeSort(Box[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            Box[] firstHalf = new Box[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            Box[] secondHalf = new Box[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /** Merge two sorted lists */
    public static void merge(Box[] list1, Box[] list2, Box[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].getVolume() < list2[current2].getVolume())
            temp[current3++] = list1[current1++];
            else
            temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    //Implement another method in Runner1 to print out your array of boxes. Youshould print a line for each box listing the length, width, and height and then the volume.
    public static void printArray (Box[] anArray) {
        for (int i = 0; i <anArray.length; i++) {
            System.out.println(  "\t" + anArray[i].length + "\t\t" + anArray[i].width + "\t\t" + anArray[i].height + "\t\t" + anArray[i].getVolume());
        }        
    }


    public static void main (String[] args) throws IOException {
        //Next, you should write a method in a class named Runner1 that will generate a random list of Boxes for testing
        Box[] generatedBoxArray = generateRandomBoxes(10000);
        
        System.out.println("Generated Array:");
        printArray(generatedBoxArray);
        System.out.println("---");

        //As another preliminary step, implement a method CopyArray in Runner1 that creates a new array of boxes with identical values of a given one. 
        Box[] copiedArray = CopyArray(generatedBoxArray);
        
        System.out.println("Copied Array:");
        printArray(copiedArray);
        System.out.println("---");

        //Insertion sort on generated array
        long startTimeInSort = 0;
        long endTimeInSort = 0;
        long estimatedTimeInSort = 0;
        System.out.println("Generated Array Sorted with Insertion Sort:");
        startTimeInSort = System.nanoTime();
        insertionSort(generatedBoxArray);
        endTimeInSort = System.nanoTime();
        estimatedTimeInSort = endTimeInSort - startTimeInSort;

        printArray(generatedBoxArray);
        System.out.println("---");

        //Merge sort on copied array
        long startTimeMergeSort = 0;
        long endTimeMergeSort = 0;
        long estimatedTimeMergeSort = 0;
        System.out.println("Copied Array Sorted with Merge Sort:");
        startTimeMergeSort = System.nanoTime();
        mergeSort(copiedArray);
        printArray(generatedBoxArray);
        endTimeMergeSort = System.nanoTime();
        estimatedTimeMergeSort = endTimeMergeSort - startTimeMergeSort;
        System.out.println("---");

        System.out.println("Estimated Time Insertion Sort: " + estimatedTimeInSort + " nanoseconds");
        System.out.println("Estimated Time Merge Sort: " + estimatedTimeMergeSort + " nanoseconds");

    }

}