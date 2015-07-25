package exceptions

class Error404 extends Exception
{
	private def message = ""

	public Error404(String address){ this.message = "Error 404 while requesting ${address}" }

	@Override String toString(){ return message}
}
