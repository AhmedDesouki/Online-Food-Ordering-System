package group.pkg6.phase.pkg3;

/**
 *
 * @author patri
 */
public interface PayStrategy 
{
    boolean pay(int paymentAmount);
    public void Make_Order(int customer_id,String date,String PaymentMethod);
    //void collectPaymentDetails();
}
