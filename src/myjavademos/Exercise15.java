package myjavademos;
/* 15.Write a program to construct an array with 10 elements and to find the number of    
occurrences of each element in the Array. */
public class Exercise15 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 6, 4, 2, 8, 6, 2, 4};
        int[] freq = new int[arr.length]; // to store frequency counts
        int visited = -1;

        for (int i = 0; i < arr.length; i++) {
            if (freq[i] == visited) continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    freq[j] = visited; // mark as visited
                }
            }
            freq[i] = count;
        }

        // Display results
        System.out.println("Element : Frequency");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != visited) {
                System.out.println("   " + arr[i] + "    :    " + freq[i]);
            }
        }
    }
}
/*
Element : Frequency
   2    :    4
   4    :    3
   6    :    2
   8    :    1
   */
