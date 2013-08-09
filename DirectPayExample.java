import com.mpowerpayments.mpower.*;
import java.io.*;

public class DirectPayExample {
	public static void main(String args[]) throws Exception {

		// Setup your API keys and mode
		MPowerSetup apiSetup = new MPowerSetup();
		apiSetup.setMasterKey("dd6f2c90-f075-012f-5b69-00155d866600");
		apiSetup.setPrivateKey("test_private_oDLVlm1eNyh0IsetdhdJvcl0ygA");
		apiSetup.setPublicKey("test_public_zzF3ywvX9DE-OSDNhUqKoaTI4wc");
		apiSetup.setToken("ca03737cf942cf644f36"); 
		apiSetup.setMode("test");

		// MPower DirectPay Request
		MPowerDirectPay co = new MPowerDirectPay(apiSetup);

		// Make the Payment
		if (co.creditAccount("alfredrowe", 30.50)) {
        System.out.println("Status: "+co.getStatus());
        System.out.println("Descripion: "+co.getDescription());
        System.out.println("Transaction ID: "+co.getTransactionId());
      }else{
        System.out.println("Status: "+co.getStatus());
        System.out.println("Response Message: "+co.getResponseText());
      }
	}
}