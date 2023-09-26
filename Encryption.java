import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {
	public static void main(String[] args)
		throws FileNotFoundException, IOException
	{
		Scanner sc = new Scanner(System.in);
		
	
		// Here key is act as password to Encrypt and
		// Decrypt the Image
		System.out.print("Enter key for Decryption : ");
		int key = sc.nextInt();
							
            // Converting Image into byte array, create a
            // array of same size as Image size
            try ( // Selecting a Image for operation
                    FileInputStream fis = new FileInputStream(
                            "C:\\Users\\Shubham\\Downloads\\signature.jpeg")) {
                // Converting Image into byte array, create a
                // array of same size as Image size
                
                byte data[] = new byte[fis.available()];
                
                // Read the array
                fis.read(data);
                int i = 0;
                
                // Performing an XOR operation on each value of
                // byte array due to which every value of Image
                // will change.
                for (byte b : data) {
                    data[i] = (byte)(b ^ key);
                    i++;
                }
                
                    // Writing new byte array value to image which
                    // will Encrypt it.
                    try ( // Opening a file for writing purpose
                            FileOutputStream fos = new FileOutputStream(
                                    "C:\\Users\\Shubham\\Downloads\\signature.jpeg")) {
                        // Writing new byte array value to image which
                        // will Encrypt it.
                        fos.write(data);
                        // Closing file
                    }
            }
		System.out.println(" Decryption Done...");
	}
}
