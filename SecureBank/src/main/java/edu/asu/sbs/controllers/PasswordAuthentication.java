import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static jdk.nashorn.tools.ShellFunctions.input;
 
public class PasswordAuthentication {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
        String hash =sha256("test");
    	System.out.println(hash);
        
        boolean result = verifyPass("test", hash);
        System.out.println("Does the file's checksum matches the expected one? " + result);
        
    }
     
    static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    public static boolean verifyPass(String enteredPass, String storedPass) throws NoSuchAlgorithmException, IOException
    {
        MessageDigest check = MessageDigest.getInstance("SHA-256");
       /* FileInputStream fis = new FileInputStream(file);
  
        byte[] data = new byte[1024];
        int read = 0; 
        while ((read = fis.read(data)) != -1) {
            
        };*/
        byte[] hashBytes = check.digest(enteredPass.getBytes());
        //check.update(hashBytes);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashBytes.length; i++) {
          sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        String fileHash = sb.toString();
        return fileHash.equals(storedPass);
    }
}

