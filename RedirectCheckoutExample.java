import com.mpowerpayments.mpower.*;

public class RedirectCheckoutExample {
	public static void main(String args[]) throws Exception {

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
		MPowerCheckoutInvoice co = new MPowerCheckoutInvoice(apiSetup, storeSetup);
		// Add invoice items
		co.addItem("Crate of Apeteshi",2,10.00,20.00);
		co.addItem("50kg Bag of Sultana Rice",1,78.50,78.50);
		co.addItem("Book - Marriage of Anansewaa",1,10.00,10.00);

		// You will need to calculated the total amout yourself.
		co.setTotalAmount(108.50);

		// Create the invoice
		if (co.create()) {
			System.out.println("Invoice URL: "+co.getInvoiceUrl());
		}else{
			System.out.println("Error Occured: "+ co.getResponseCode());
			System.out.println(co.getResponseText());
		}
	}
}