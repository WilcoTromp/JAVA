
/**
 * Write a description of class StudentClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudentClient extends Client
{
   private String code;
   private double bursaryAmount;
   private static int count = 800;
   private final double RATE = 1.5;
   
   public StudentClient()
   {
   }   
    public StudentClient(String name, String surname, String idNumber, String contactNumber, double balance, double bursaryAmount)
    {
       super(name, surname, idNumber, contactNumber, balance);
       setBursaryAmount(bursaryAmount);
       count++;
       setCode(count);       
    }
    public double getBursaryAmount()
    {
        return bursaryAmount;
    }
    public void setBursaryAmount(double bursaryAmount)
    {
       this.bursaryAmount = bursaryAmount;
    }
    
    public String getCode()
    {
        return code;
    }
    public void setCode(int count)
    {
       this.code = "Stud" + count;
    }
    
    public void withdraw(double amount, String type)
    {
        double newBalance = 0;
        if (type.equalsIgnoreCase("Balance"))
            newBalance = super.getBalance() - amount;
        else
            newBalance = bursaryAmount - amount; 
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
        String str = String.format("%s%s%s\n%sR%8.2f\n",super.toString(),"Code: ", code, "Bursary amount: ", bursaryAmount );
        return str;
    }
}