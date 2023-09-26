import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Decryption {

	public static void main(String[] args)
		throws FileNotFoundException, IOException
	{
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter a key for Encryption and Decryption : ");
		int key = sc.nextInt();
		
            // Converting image into byte array,it will
            // Create a array of same size as image.
            try ( // Selecting a Image for Decryption.
                    FileInputStream fis = new FileInputStream(
                            "C:\\Users\\Shubham\\Downloads\\signature.jpeg")) {
                // Converting image into byte array,it will
                // Create a array of same size as image.
                byte data[] = new byte[fis.available()];
                
                // Read the array
                
                fis.read(data);
                int i = 0;
                
                // Performing an XOR operation
                // on each value of
                // byte array to Decrypt it.
                for (byte b : data) {
                    data[i] = (byte)(b ^ key);
                    i++;
                }
                
                    // Writting Decrypted data on Image
                    try ( // Opening file for writting purpose
                            FileOutputStream fos = new FileOutputStream(
                                    "C:\\Users\\Shubham\\Downloads\\signature.jpeg")) {
                        // Writting Decrypted data on Image
                        fos.write(data);
                    }
            }
		System.out.println("Encryption and Decryption Done...");
	}
}
