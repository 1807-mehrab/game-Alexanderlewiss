package banking ;
import java.util.Scanner; 
/**
 * Hello world!
 *
 */
public class App 
{
      private double checkingAccount;
      private double savingsAccount; 
      private double amount; 
      public Bankingapp() []; 
      
      public Bankingapp(double checkingAccount, double savingsAccount, double amount)
      {
           this.checkingAccount = checkingAccount; 
           this.savingsAccount = savingsAccount; 
           this.amount = amount; 
      }

      public double deposit(double dAmount)
      {   
          Scanner a = new Scanner (System.in);
          System.out.println("Enter deposit amount");
          dAmount = scanner.nextDouble();

          double sum = 0.0; 
          checkingAccount += dAmount; 

          return dAmount; 

      }

     
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
