
/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;
public abstract class Client implements Clientable, Serializable
{
   private String name;      
   private String surname;
   private String IDNumber;
   private String contactNumber;
   private double balance; 
   
   public Client()
   {
   }
    
  public Client(String name, String surname, String IDNumber, String contactNumber, double balance)
    {
       setName(name);
       setSurname(surname);
       setIDNumber(IDNumber);
       setContactNumber(contactNumber);
       setBalance(balance); 
     }
       
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getIDNumber()
    {
        return IDNumber;
    }
    public String getContactNumber()
    {
        return contactNumber;
    }
       
    public double getBalance()
    {
        return balance;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    public void setIDNumber(String IDNumber)
    {
        this.IDNumber = IDNumber;
    }
    
    public void setContactNumber(String newNumber)
    {
        contactNumber = newNumber;
    }
        
    public void setBalance(double newBalance)
    {
        balance = newBalance;
    }
    
    public void deposit(double amount)
    {
        if (amount >= 0)
            balance = balance + amount;
    }
    
    public abstract double calcInterest();
    
    @Override
    public String toString()
    {
        String str = String.format("%s%s\n%s%s\n%s%s\n%sR%8.2f\n","Name: ", name + " " + surname , "IDNumber: " , IDNumber,"Contact number: ", contactNumber, "Balance: ", balance );
        return str;
    }
}
