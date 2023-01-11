
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
//import java.io.EOFException;

public class BinaryInputDemo
{
  public static void main(String[] args) //reads from number.bin (like reading from a scanner)
  {
     try
     {
          DataInputStream inputStream = 
           new DataInputStream(new FileInputStream("numbers.bin"));

         System.out.println("Reading the file numbers.bin.");
         

        int n1 = inputStream.readInt( );
        int n2 = inputStream.readInt( );
        double n3 = inputStream.readDouble();

        System.out.println("Numbers read from file:");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

              
         inputStream.close( );

     }
     catch(FileNotFoundException e)
     {
         System.out.println("Cannot find file numbers.bin.");
     }
     catch(IOException e)
     {
         System.out.println("Problems with input from numbers.bin.");
     }
     finally
     {

     }
  }
}


