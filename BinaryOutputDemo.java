

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryOutputDemo
{
   public static void main(String[] args) //writes to number.bin (like writing data with scanner)
   {
      try
      {
        DataOutputStream outputStream =
             new DataOutputStream(new FileOutputStream("numbers.bin"));

         int i;
         for (i = 0; i < 5; i++){
             outputStream.writeInt(i);
             System.out.println(i);
         }

         System.out.println("Numbers written to the file numbers.bin.");
         outputStream.close( );
      }
      catch(IOException e)
      {
         System.out.println("Problem with file output.");
      }
   }
}
