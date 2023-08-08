
/**
 * Write a description of class FileClass here.
 *
 * @author (Wilco Tromp)
 * @version (2021/06/06)
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.NumberFormat;

public class FileClass
{
    Clientable [] arrClients = new Clientable[20];
    int count = 0;
           
    public void readFromFile()
    {
        try
        {
            Scanner sc = new Scanner(new FileReader("data.txt"));
            
            while (sc.hasNext())
            {
                String line = sc.nextLine();
                String [] info = line.split(",");
                
                String type = info[0];
                String name = info[1];
                String surname = info[2];
                String IDnumber = info[3];
                String contactNum = info[4];
                double balance = Double.parseDouble(info[5]);
                if (type.equals("Sa"))
                {
                    arrClients[count] = new SavingsClient(name, surname, IDnumber,contactNum, balance);
                }
                
                if (type.equals("St"))
                {
                    double bursaryAmount = Double.parseDouble(info[6]);
                    arrClients[count] = new StudentClient(name, surname, IDnumber,contactNum, balance, bursaryAmount);
                }
                                
                if (type.equals("Ch"))
                {
                    arrClients[count] = new ChequeClient(name, surname, IDnumber,contactNum, balance);
                }
                if (type.equals("Co"))
                {
                    double bankfee = Double.parseDouble(info[6]);
                    String compName = info[7];
                    arrClients[count] = new CompanyClient(name, surname, IDnumber,contactNum, balance, bankfee, compName);
                }
                count++;
            } // while
            sc.close();
        } // try
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error reading the file");
        }
    }
    
    public Clientable [] getArray()
    {
        return arrClients;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public static void serializeAcc(Clientable [] arrClients, int count)
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new
                    FileOutputStream("cheque.ser"));

            for (int k = 0; k < count; k++)
            {
                if(arrClients[k] instanceof ChequeClient)
                    out.writeObject(arrClients[k]);
            }
            out.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void readChequeData()
    {
        System.out.println("List of cheque clients");

        try
        {
            ObjectInputStream in = new ObjectInputStream(new
                    FileInputStream("cheque.ser"));

            while (true)
            {
                Client cheque = (Client) in.readObject();
                System.out.printf("%-20s%-15s\n", cheque.getName(), NumberFormat.getCurrencyInstance().format(cheque.getBalance()));
            }
        }
        catch (EOFException endOfFileException)
        {
            System.out.println("No more records");
            System.exit(1);
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch (IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }
}
        