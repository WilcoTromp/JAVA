
/**
 * Write a description of class testBankAccount here.
 * 
 * @author (Wilco Tromp) 
 * @version (2021/06/06)
 */


public class testBankAccount
{
    
    public static void main(String [] args)
    {
        System.out.print("\f");
        
        Clientable [] arrClients = new Clientable[20];
        int count = 0;
        
        FileClass file = new FileClass();
        file.readFromFile();
        arrClients = file.getArray();
        count = file.getCount();
        
        display(arrClients,count);
        
        FileClass.serializeAcc(arrClients, count);
        
        file.readChequeData();
    }
    
      
    public static void display(Clientable [] arrClients, int count)
    {
      
        for(int k = 0; k < count; k++)
        {
            Clientable client = arrClients[k];
            System.out.println(client.toString());                         
        }       
    }
    
    
}