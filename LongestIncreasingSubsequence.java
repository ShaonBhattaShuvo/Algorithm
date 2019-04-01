import java.util.Scanner;

/*
 * @author Shaon Bhatta Shuvo
 */
public class LongestIncreasingSubsequence {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Array length: ");
        int arrayLength = input.nextInt();
        int a[] = new int[arrayLength];
        System.out.print("Insert array elements: ");
        for (int i = 0; i < arrayLength; i++) {
            a[i]=input.nextInt();
        }
        longestIncreasingSubsequence(a);
    }
    public static void longestIncreasingSubsequence(int a[]){
        //lis will provide the longest common subesequece length
        int lis[]=new int[a.length];
        //trace array will help us to trace the the sequence
        int trace[]=new int[a.length];
        //initializing lis array with value 1
        for (int i = 0; i < lis.length; i++) {
            lis[i]=1;
        }
        //initializing trace with value -1, values -1 means it has no previous element
        for (int i = 0; i < trace.length; i++) {
            trace[i]=-1;
        }
        //updating the lis array to get the lis value
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i]>a[j] && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                    trace[i]=j;
                }
            }
        }
        //maximus value of lis array is the value we are looking for
        int max =lis[0], index=0;
        for (int i = 1; i < lis.length; i++) {
            if(max<lis[i]){
                max=lis[i];
                index=i;        
            }
        }
        System.out.print("\nLength of LIS="+max);
        //System.out.println("index"+index);
        System.out.print("\nSequece:");
        printSequence(a,trace,index);
    }
    //method for printing the sequence 
    public static void printSequence(int a[],int trace[],int index){
        if(trace[index]==-1) {
            System.out.println(a[index]+" ");
            return;
        }
        index=trace[index];
        printSequence(a,trace,index);
        System.out.print(a[index]+ " ");
    }
}
