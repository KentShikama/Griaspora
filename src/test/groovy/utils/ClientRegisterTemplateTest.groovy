package utils

class ClientRegisterTemplateTest extends GroovyTestCase
{
	def client = new ClientRegisterTemplate("http://localhost:3000", "diaspora client", ["http://localhost:3000/"])

	void testPost()
	{
		println client.post()
	}
}
