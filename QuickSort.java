import java.util.Scanner;

/**
 * @author Shaon Bhatta Shuvo
 */
public class QuickSort {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of the array:");
        n= input.nextInt();
        int a[] = new int[n];
        //taking array input
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        //calling quickSort method where begin=0 and end = a.length-1
        quickSort(a,0,a.length-1);
        //printing the array after sorting 
        for (int k = 0; k < a.length; k++) {
                System.out.print(a[k]+" ");
        }
    }
    //partition method
    public static int partition(int a[], int begin1, int end1){
            int i=begin1-1;
            int j=begin1;
            int x = a[end1];
            for (; j < end1; j++) {
                if(x>a[j]){
                    i = i+1;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j]=temp;
                }
            }
            i = i+1;
            int temp = a[i];
            a[i] = a[j];
            a[j]=temp;
//we can print the array and the value of i to check whether the partition method working properly or not       
//            for (int k = 0; k < a.length; k++) {
//                System.out.print(a[k]+" ");
//            }
//            System.out.println("i="+i);
            return i;
            
    }
    public static void quickSort(int a[], int begin, int end){
        if(begin<end){
            int pivot=  partition(a, begin, end);
            quickSort(a, begin, pivot-1);
            quickSort(a, pivot+1, end);
        }
        
    }
    
}
