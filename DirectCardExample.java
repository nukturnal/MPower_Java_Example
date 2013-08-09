import com.mpowerpayments.mpower.*;
import java.io.*;

public class DirectCardExample {
	public static void main(String args[]) throws Exception {

		// Setup your API keys and mode
		MPowerSetup setup = new MPowerSetup();
		setup.setMasterKey("f831d006-a999-431a-9fa9-10cdb1709352");
		setup.setPrivateKey("test_private_hrZpJkVOFALfIr0w4nS6kKlcsuY");
		setup.setPublicKey("test_public_zSpBTW9kFW7CBoviY49IiVmB7lI");
		setup.setToken("c1ee9aab24d755f5dc52"); 
		setup.setMode("test");

		// MPower DirectCard Charge Request
		MPowerDirectCard card = new MPowerDirectCard(setup);

		if (card.charge(30.60,"Alfred Rowe","4242424242424242","123","06","2014")) {
        System.out.println("Status: "+card.getStatus());
        System.out.println("Descripion: "+card.getDescription());
        System.out.println("Transaction ID: "+card.getTransactionId());
        System.out.println("Unity Transaction ID: "+card.getUnityTransactionId());
      }else{
        System.out.println("Status: "+card.getStatus());
        System.out.println("Response Message: "+card.getResponseText());
      }
	}
}