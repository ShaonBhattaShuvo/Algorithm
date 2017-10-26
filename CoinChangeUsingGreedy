import java.util.Scanner;

/**
 *
 * @author Shaon Bhatta Shuvo
 */
public class CoinChangeGreedy {
 
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n, amount;
        System.out.println("Enter the amount you want change: ");
        amount = input.nextInt();
        System.out.println("How many different set of coins are available: ");
        n = input.nextInt();
        int coin[] = new int[n];
        System.out.println("Enter the set of available coins in descending oreder: ");
        for (int i = 0; i < n; i++) {
            coin[i]=input.nextInt();
        }
        coinChangeGreedy(coin, amount);
    }
    public static void coinChangeGreedy(int coin[], int amount){
        int coinNeeded=0,actualAmount=amount;
        for(int i=0;i<coin.length;i++){
                coinNeeded=coinNeeded+(amount/coin[i]);
                amount=amount%coin[i];
        }
        System.out.println("Minimum "+coinNeeded+" coins are required!");
        //to track each coin individually 
        //int coinUsed[] = new int[coinNeeded];
        for(int i=0;i<coin.length;i++){
                if((actualAmount/coin[i])!=0)
                    System.out.println(coin[i] + " requirs "+actualAmount/coin[i]+" unit");
               actualAmount=actualAmount%coin[i];
        }
        //checking whether the problem has a solution or not !
        if(amount !=0){
          System.out.println("Problem does't have a solution for given set of coins as still amount "+amount+"Tk. has to be changed! ");
       }
    }
}
