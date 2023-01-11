/*Generates a text file containing 3 sets of values that represent a bank account
 * stores the values into a text file and a binary file
 * 
 */
import java.util.Scanner; //reads from keybaord
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.DataOutputStream; //writes to binary file
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.PrintWriter; //writes
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class fileIOdemo {

	public static void main(String[] args) { //READING AND WRITING BOTH TEXT AND BINARY FILES
		// TODO Auto-generated method stub
		try (
			Scanner kb = new Scanner(System.in);
			PrintWriter outtxtf = new PrintWriter(new File ("accounts.txt"));
			ObjectOutputStream outbinf = new ObjectOutputStream(new FileOutputStream("accounts.bin"));
		){
		
		
		String name;
		double balance;
		
		for (int i=0; i<3; i++) {
			System.out.println("Enter Name");
			name= kb.next();
			System.out.println("Enter balance");
			balance=kb.nextDouble();
			
			outtxtf.println("Name: " + name + "\tAccount Number" + (i+1) + "\tBalance: " + balance);
			outbinf.writeObject (new Account (i+1, name, balance));
		}
		outtxtf.close();
		outbinf.close();
	}
		catch(FileNotFoundException ex) {
			System.out.println("Wrong dum dum");
		}
		catch(IOException ex) {
			System.out.println("Wrong dum dum");
		}
		
		try(
			ObjectInputStream inbinf = new ObjectInputStream(new FileInputStream("accounts.bin"));	
		){
			try {
				while(true) {
					Account acct = (Account) inbinf.readObject();
				}
			}
			catch(EOFException ex) {
				System.out.println("END OF FILE");
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("Wrong dum dum");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Wrong dum dum");
		}
		catch(IOException ex) {
			System.out.println("Wrong dum dum");
		}
	}
}


