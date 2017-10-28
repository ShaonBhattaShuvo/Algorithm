import java.util.Scanner;

/**
 *
 * @author Shaon Bhatta Shuvo
 */
public class CoinChangeDP {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n, amount;
        System.out.println("Enter the amount you want change: ");
        amount = input.nextInt();
        System.out.println("How many different set of coins are available: ");
        n = input.nextInt();
        int coin[] = new int[n];
        System.out.println("Enter the set of available coins in ascending oreder: ");
        for (int i = 0; i < n; i++) {
            coin[i]=input.nextInt();
        }
        coinChange(coin, amount);
    }

    private static void coinChange(int[] coin, int amount) {
        int row = coin.length;
        int col = amount+1;
        int table[][] = new int[row][col];
        //assigning value to the first coloumn 
        for (int i = 0; i < row; i++) {
            table[i][0]=0;
        }
        //assinging value of the first row
        for (int j = 1; j < col; j++) {
            table[0][j] = j/coin[0];
        }
        //assing value to the rest of table 
        for (int i = 1; i <row; i++) {
            for (int j = 1; j <col; j++) {
                if (j<coin[i]) {
                    table[i][j]=table[i-1][j];
                }else{
                  
                    table[i][j]=Math.min(table[i-1][j], table[i][j-coin[i]]+1);
                }
            }
        }
        System.out.println("Minimum number of coins : "+table[row-1][col-1]);
        
        //finding the set of coins required to get the value 
        int i = row-1,j = col-1, count=0;
        System.out.print("Required coins are: ");
        while(i>0 && j>0){
            if(table[i-1][j]==table[i][j]){
                i--;
                continue;
            }
            //printing the required coins or it can be stored in a seperate array as well. 
            System.out.print(coin[i]+" ");
           
            
            j = j-coin[i];
            amount = amount-coin[i];
            count++;
            
        }
      //if required coins also includes the first coin
        while(count!=table[row-1][col-1] && amount>=coin[i]){
            System.out.print(coin[i]+" ");
            amount = amount-coin[i];
        }
      //checking wheather the problem has a solution or will left with some remaining values! 
       if(amount !=0){
          System.out.println("\nProblem does't have a solution for given set of coins as still amount "+amount+" Tk. has to be changed! ");
       }
        
    }
    
}
