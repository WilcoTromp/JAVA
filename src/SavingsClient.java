
/**
 * Write a description of class SavingsClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SavingsClient extends Client
{
   private String code;
   private static int count = 500;
   private final double RATE = 4.5;
   
   public SavingsClient()
   {
   }  
   
    public SavingsClient(String name, String surname, String idNumber, String contactNumber, double balance)
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
       this.code = "Save" + count;
    }
    
    public void withdraw(double amount)
    {
        double newBalance = super.getBalance() - amount;
        super.setBalance(newBalance);
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