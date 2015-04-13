package JerseyRestClientPkg;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyRestClient {

	public static void main(String[] args) {
		
		JerseyRestClient jerseyRestClientObj = new JerseyRestClient();
		jerseyRestClientObj.getResponse();
		jerseyRestClientObj.postResponse();

	}
	
	private void getResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource1 = client.resource("http://10.43.1.107:35357/v2.0");
			ClientResponse response1 = webResource1.accept("application/json").get(ClientResponse.class);
			if (response1.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response1.getStatus());
			}
 
			String output1 = response1.getEntity(String.class);
			System.out.println("\n============getResponse============");
			System.out.println(output1);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void postResponse() {
		try {
 
			Client client = Client.create();
			WebResource webResource2 = client.resource("http://10.43.1.107:35357/v2.0/tokens");
			String urlParameters = "{\"auth\": {\"tenantName\":\"admin\",\"passwordCredentials\":{\"username\":\"admin\",\"password\":\"OpenstacK123\"}}}";
			ClientResponse response2 = webResource2.accept("application/json").type("application/json").post(ClientResponse.class, urlParameters);
			if (response2.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
			}
 
			String output2 = response2.getEntity(String.class);
			System.out.println("\n============postResponse============");
			System.out.println(output2);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
