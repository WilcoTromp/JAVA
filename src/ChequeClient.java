
/**
 * Write a description of class ChequeAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChequeClient extends Client
{
   private String code;
   private static int count = 100;
   private final double RATE = 2.5;
   
   public ChequeClient()
   {
   }  
   
    public ChequeClient(String name, String surname, String idNumber, String contactNumber, double balance)
    {
       super(name, surname, idNumber, contactNumber, balance);
       count++;
       setCode(count);        
    }
       
    public String getCode()
    {
        return code;
    }
    public void setCode(int count)
    {
        this.code = "Cheque" + count;
    }
    
    public void withdraw(double amount)
    {
        double result = super.getBalance() - amount;
        super.setBalance(result);
    }
    
    public double calcInterest()
    {
      double interest = super.getBalance() * (RATE/100);
      return interest;
    }
    @Override
    public String toString()
    {
        String str = String.format("%s%s%s\n",super.toString(),"Code: ", code );
        return str;
    }
}