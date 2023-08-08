
/**
 * Write a description of class CompanyClient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompanyClient extends Client
{
   private String code;
   private String companyName;
   private double bankfee;
   private static int count = 900;
   private final double RATE = 1.5;
   
   public CompanyClient()
   {
   } 
   
    public CompanyClient(String name, String surname, String idNumber, String contactNumber, double balance, double bankfee, String companyName)
    {
       super(name, surname, idNumber, contactNumber, balance);
       setBankfee(bankfee);
       setCompName(companyName);
       count++;
       setCode(count);       
    }
    public double getBankFee()
    {
        return bankfee;
    }
    public void setBankfee(double bankfee)
    {
       this.bankfee = bankfee;
    }
    public String getCompName()
    {
        return companyName;
    }
    public void setCompName(String companyName)
    {
       this.companyName = companyName;
    }
    
    public String getCode()
    {
        return code;
    }
    public void setCode(int count)
    {
       this.code = "Comp" + count;
    }
    
    public void withdraw(double amount)
    {
        double newBalance = 0;
        newBalance = super.getBalance() - amount;
        super.setBalance(newBalance);
        bankfee = bankfee + 100;
        
    }
          
    public double calcInterest()
    {
      double interest = super.getBalance() * (RATE/100);
      return interest;
    }
    @Override
    public String toString()
    {
        String str = String.format("%s%s%s\n%sR%8.2f\n%s%s\n",super.toString(),"Code: ", code, "Bankfee: ", bankfee, "Company name: ", companyName );
        return str;
    }
}