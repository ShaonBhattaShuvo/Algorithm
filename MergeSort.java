
package algorithm;

import java.util.Scanner;

/**
 *
 * @author Shaon Bhatta Shuvo
 */
public class MergeSort {
    
   public static void main(String args[]){
       Scanner input = new Scanner(System.in);
       int n;
       System.out.println("Enter the size of array:");
       n=input.nextInt();
       int inputArray[] = new int[n];
       System.out.println("Enter an array: ");
       //taking array input
       for (int i = 0; i < n; i++) {
           inputArray[i]=input.nextInt();
       }
       //applying mergesort to the array
       mergeSort(inputArray,0,inputArray.length-1);
       //printing the sorted arraay
       for (int i = 0; i < inputArray.length; i++) {
           System.out.print(inputArray[i]+" ");
       }
       
   }
    public static void mergeSort(int a[], int begin, int end){
         if(begin<end){
             int mid = (begin+end)/2;
             mergeSort(a,begin,mid);
             mergeSort(a,mid+1,end);
             merge(a,begin,mid,end);
         }    
    }
    
    public static void merge(int a[], int begin, int mid, int end){
        int left_n = mid-begin+1;
        int right_n = end-mid;
        //both array an extra space to put the infinite value at the end ! 
        int left[] = new int[left_n+1]; 
        int right[] = new int[right_n+1];
        for (int i = 0; i < left_n; i++) {
            left[i] = a[begin+i];
        }
        for (int i = 0; i < right_n; i++) {
            right[i]=a[mid+1+i];
        }
        //putting infinity(a very large value and the end )
        left[left_n]= Integer.MAX_VALUE; // or put something like 123456789
        right[right_n]=Integer.MAX_VALUE;
        int i=0,j=0;
        for (int k = begin; k <= end; k++) {
            if(left[i]<=right[j]){
                a[k]=left[i];
                i++;
            }else{
                a[k]=right[j];
                j++;
            }
        }
        
    }

}
