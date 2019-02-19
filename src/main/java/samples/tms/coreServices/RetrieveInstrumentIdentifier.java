package samples.tms.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.InstrumentIdentifierApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.TmsV1InstrumentidentifiersPost200Response;

public class RetrieveInstrumentIdentifier {
	private String profileId = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private Properties merchantProp;
	
	public static void main(String args[]) throws Exception {
		RetrieveInstrumentIdentifier instrumentIdentifier =new RetrieveInstrumentIdentifier();
		instrumentIdentifier.process();
	}


	private  void process() throws Exception {
		String className=RetrieveInstrumentIdentifier.class.getSimpleName();
		System.out.println("[BEGIN] EXECUTION OF SAMPLE CODE: "+className+"\n");
		ApiClient apiClient = new ApiClient();
		try {
			/* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			CreateInstrumentIdentifier createInstrumentIdentifier =new CreateInstrumentIdentifier();
			TmsV1InstrumentidentifiersPost200Response post200Response=createInstrumentIdentifier.process();
			if (post200Response != null) {
				InstrumentIdentifierApi instrumentIdentifierApi = new InstrumentIdentifierApi(merchantConfig);
				apiClient=Invokers.Configuration.getDefaultApiClient();
				instrumentIdentifierApi.tmsV1InstrumentidentifiersTokenIdGet(profileId, post200Response.getId());
			}
		} catch (ApiException e) {
			System.out.println("Exception on calling the Sample Code " +className+": "+apiClient.getRespBody()+"\n");
		} finally {
			System.out.println("API REQUEST HEADERS:");
			System.out.println(apiClient.getRequestHeader() + "\n");
			System.out.println("API RESPONSE CODE: " + apiClient.getResponseCode() + "\n");
			System.out.println("API RESPONSE HEADERS:");
			System.out.println(apiClient.getResponseHeader() + "\n");
			System.out.println("API RESPONSE BODY:");
			System.out.println(apiClient.getRespBody() + "\n");
			System.out.println("[END] EXECUTION OF SAMPLE CODE: " + className + "\n");
		}
	}

}
