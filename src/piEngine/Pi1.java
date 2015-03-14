package piEngine;



public class Pi1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Process client=new Process("Client","a?p . p!doc");
		Process server=new Process("server", "a!b . Server");
		Process printer=new Process("printer", "b?doc . Println(doc) . Printer");
		Interpret i=new Interpret();
		//i.place(client.getCharKey(), client);
		//i.place(server.getCharKey(), server);
		//i.place(printer.getCharKey(), printer);
		//i.process();
		while(client.getContent().contains("!")||client.getContent().contains("?")|| server.getContent().contains("!")
				||server.getContent().contains("?")||printer.getContent().contains("!")||printer.getContent().contains("?")){
			{
				i.place(client.getCharKey(), client);
				i.place(server.getCharKey(), server);
				i.place(printer.getCharKey(), printer);
				i.process();
				
		}
			
		
		/*if(client.getCharKey().equals(server.getCharKey())){
			int i=client.getContent().indexOf(client.getCharKey());
			client.getContent().charAt(i+1);
			server.getContent().charAt(i+1);
		}*/

	
		}
		}
}
