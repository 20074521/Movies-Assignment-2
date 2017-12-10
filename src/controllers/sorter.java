package controllers;

import java.util.Random;

import edu.princeton.cs.introcs.Stopwatch;

public class sorter {
	 public static int[] doSort(int[] a){

	        for (int i = 0; i < a.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < a.length; j++)
	                if (a[j] < a[index])
	                    index = j;

	            int smallerNumber = a[index]; 
	            a[index] = a[i];
	            a[i] = smallerNumber;
	        }
	        return a;
	    }
	 public static int[] generateIntArray(int n) {
	        Random rand = new Random();

	        int [] array = new int[n];

	        for (int i=0;i<n;i++)
	            array[i]=rand.nextInt();

	        return array;
	    }
	 public static void main(String[] args) {
         int[] a = generateIntArray(10000);
         Stopwatch    stopwatch = new Stopwatch();
         doSort(a);
         double    time = stopwatch.elapsedTime(); 
         System.out.println("elapsed    time " + time);
   }
}
