

class ClientTest extends GroovyTestCase
{
	def client = new Client()
	void testRegister()
	{
		println client.register("http://localhost:3000")
	}
}
