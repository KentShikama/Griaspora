package utils


import groovy.json.JsonBuilder
import groovyx.net.http.RESTClient

import static groovyx.net.http.ContentType.JSON

class ClientRegisterTemplate
{
	private RESTClient restClient
	private String clientName
	private List redirectURI

	public ClientRegisterTemplate(String address, String clientName, List<String> redirectURI)
	{
		this.restClient = new RESTClient(address)
		this.clientName = clientName
		this.redirectURI = redirectURI
	}

	public String post()
	{
		def response = []
		try{
			 response = this.restClient.post(
				path: Endpoints.CLIENTS_ENDPOINT,
				body: [
					redirect_uris: redirectURI,
					client_name: clientName
				],
				requestContentType: JSON
			)['data']
		}
		catch(Exception e){ e.printStackTrace() }

		return new JsonBuilder(response).toPrettyString()
	}
}
