/*
Author: Edgar E. Rodriguez
TAs: Anthony M Ortiz Cepeda and Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 09/15/16
Goals: Read the widht, height, and length of packages from file, and calculate the following:
*/

import java.util.*;
import java.io.*;

public class Runner1 {

    public static Box[] generateRandomBoxes (int arraySize) {
        Box[] generatedBoxArray = new Box[arraySize];

        for (int i = 0; i < arraySize; i++) {
            generatedBoxArray[i] = new Box( (Math.random()*100), (Math.random()*100), (Math.random()*100) );
        }
        return generatedBoxArray;
    }

    public static Box[] CopyArray (Box[] anArray) {
        Box[] copiedArray = new Box[anArray.length];

        for (int i = 0; i < anArray.length; i++) {
            copiedArray[i] = new Box( anArray[i].width, anArray[i].height, anArray[i].length );
        }
        return copiedArray;
    }

    public static void main (String[] args) throws IOException {
        Box[] generatedBoxArray = generateRandomBoxes(20);
        for (int i = 0; i <generatedBoxArray.length; i++) {
            System.out.println(generatedBoxArray[i].length + "\t" + generatedBoxArray[i].width + "\t" + generatedBoxArray[i].height + "\t" + generatedBoxArray[i].getVolume() );
        }

        System.out.println("---");

        Box[] copiedArray = CopyArray(generatedBoxArray);
        for (int i = 0; i < copiedArray.length; i++) {
            System.out.println(copiedArray[i].length + "\t" + copiedArray[i].width + "\t" + copiedArray[i].height + "\t" + copiedArray[i].getVolume() );
        }


    }

}