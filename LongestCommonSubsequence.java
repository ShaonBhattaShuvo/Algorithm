import java.util.Scanner;
/*
 * @author Shaon Bhatta Shuvo
 */
public class LongestCommonSubsequence {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first string:");
        String s1=input.nextLine();
        System.out.println("Enter second string");
        String s2=input.nextLine();
        longestCommonSubsequence(s1,s2);
        
    }
    public static void longestCommonSubsequence(String s1, String s2){
        int row=s1.length()+1;
        int col =s2.length()+1;
        int table[][] = new int[row][col];
        //initialializing first column to 0
        for (int i = 0; i < row; i++) {
            table[i][0]=0;
        }
        //initializing first row to 0
        for (int j = 0; j < col; j++) {
            table[0][j]=0;
        }
        //assigning value to the rest of the table
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //index of string starts from 0
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                }else{
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                }
                //System.out.print(table[i][j]+" ");
            }
            //System.out.println();
        }
        //printing the length of longest common subsequence 
        System.out.println(table[row-1][col-1]);
        //tracing sequence
        System.out.print("Sequnce is: ");
        int i=row-1, j=col-1;
        int sequenceLength = table[row-1][col-1];
        //creating an array of to store LCS
        char sequence[] = new char[sequenceLength];
        while(i>0 && j>0){
            if (table[i][j] == table[i - 1][j - 1] + 1 && s1.charAt(i - 1) == s2.charAt(j - 1)) {
                //inserting sequence(LCS) into an array
                sequence[--sequenceLength] = s1.charAt(i - 1);
                i = i - 1;
                j = j - 1;
            } else if (table[i][j] == table[i - 1][j]) {
                i = i - 1;
            } else {
                j = j - 1;
            }

        }
        //printing LCS
        for (int k = 0; k <sequence.length; k++) {
            System.out.print(sequence[k]);
        }
    }
}
