import groovy.json.JsonSlurper
import utils.ClientRegisterTemplate

class Client
{
	private String client_id
	private String client_secret

	public Client(String client_id="", String client_secret="")
	{
		this.client_id = client_id
		this.client_secret = client_secret
	}

	public Client register(String URL, List<String> redirectURLs=["http://localhost:3000"] )
	{
		def json = new JsonSlurper().parseText(
			new ClientRegisterTemplate(
				URL, "diaspora test client", redirectURLs).post()
		)

		this.client_id = json["o_auth_application"]["client_id"]
		this.client_secret = json["o_auth_application"]["client_secret"]

		return this
	}

	@Override
	public String toString()
	{
		return "Client{ client_id='$client_id', client_secret='$client_secret' }"
	}
}
