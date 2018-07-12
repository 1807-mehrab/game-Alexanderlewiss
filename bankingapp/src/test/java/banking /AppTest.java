package banking ;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

 

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App bank = new App();

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test 
    public void checkDepositAmount(double a )
    {
       double maxDeposit = 1000.00;
       double actualDeposit = bank.deposit(a);
       assertEquals(actualDeposit, maxDeposit);
    }
}
