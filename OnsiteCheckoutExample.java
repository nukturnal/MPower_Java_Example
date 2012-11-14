import com.mpowerpayments.mpower.*;
import java.io.*;

public class OnsiteCheckoutExample {
	public static void main(String args[]) throws Exception {

		// We will accept the Confirmation Token from the Command prompt
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String confirmToken = null;

		// Setup your API keys and mode
		MPowerSetup apiSetup = new MPowerSetup();
		apiSetup.setMasterKey("82403450-ee3a-4c57-9564-a8fbe30c5fb7");
		apiSetup.setPrivateKey("test_private_jKxSyaylcQdrQcuxAOFAbxvK5w4");
		apiSetup.setPublicKey("test_public_M6-fRS1RCnzlGqgeLaBF5vLLoKs");
		apiSetup.setToken("7f6c81c1ea223674416e"); 
		apiSetup.setMode("test");

		// Setup your store information
		MPowerCheckoutStore storeSetup = new MPowerCheckoutStore();
		storeSetup.setName("My Awesome Online storeSetup");
		storeSetup.setTagline("This is an awesome Java storeSetup.");
		storeSetup.setPhoneNumber("024000001");
		storeSetup.setPostalAddress("606 Memorylane Chokor no.1 Road.");
		storeSetup.setWebsiteUrl("http://my-awesome-long-website-url.com/");

		// Start creating an MPower Checkout
		MPowerOnsiteInvoice co = new MPowerOnsiteInvoice(apiSetup, storeSetup);
		// Add invoice items
		co.addItem("Crate of Apeteshi",2,10.00,20.00);
		co.addItem("50kg Bag of Sultana Rice",1,78.50,78.50);
		co.addItem("Book - Marriage of Anansewaa",1,10.00,10.00);

		// You will need to calculated the total amout yourself.
		co.setTotalAmount(108.50);

		// Create the invoice
		if (co.create("0244124660")) {
			System.out.println("OPR Token: "+co.token);
			System.out.println("Invoice Token: "+co.invoiceToken);
			System.out.println("Response Message: "+co.getResponseText());

			System.out.println("\nEnter Confirmation Code: ");
			try {
         confirmToken = br.readLine();
      } catch (IOException ioe) {
         System.out.println("Could not read confirmation token");
         System.exit(1);
      }

      // Issue a Charge using your OPR Token + the confirmation token
      if (co.charge(co.token, confirmToken)) {
      	System.out.println("Status: "+co.token);
				System.out.println("Receipt URL: "+co.getReceiptUrl());
				System.out.println("Response Message: "+co.getResponseText());
      }else{
      	System.out.println("Status: "+co.token);
				System.out.println("Response Message: "+co.getResponseText());
      }

		}else{
			System.out.println("Error Occured: "+ co.getResponseCode());
			System.out.println(co.getResponseText());
		}
	}
}