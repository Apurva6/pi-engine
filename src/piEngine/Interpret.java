package piEngine;

import java.util.HashMap;

public class Interpret {
	
	Process client=new Process("Client","a?p . p!doc.");
	Process server=new Process("server", "a!b . Server.");
	Process printer=new Process("printer", "b?doc . Println(doc) . Printer.");
	String writers;
	//int len=writers.length;
	HashMap<String, Object> hmReader=new HashMap<String, Object>();
	HashMap<String, Object> hmWriter=new HashMap<String, Object>();
	public void work(){
	
		while(client.getContent().contains("!")||client.getContent().contains("?")|| server.getContent().contains("!")
				||server.getContent().contains("?")||printer.getContent().contains("!")||printer.getContent().contains("?"))
			{
				this.place(client.getCharKey(), client);
				this.place(server.getCharKey(), server);
				this.place(printer.getCharKey(), printer);
				this.process();
				
		}
		}
		//this.place(client.getCharKey(), client);
	//this.place(server.getCharKey(), server);
	//this.place(printer.getCharKey(), printer);
	//this.process();
	
	
	//System.out.println(hm.keySet());
	
	//}
	
	public void place(String s,Process o){
		if(s==" "){
		writers=o.getWriterChar();
		hmWriter.put(o.getWriterChar(), o);
		//System.out.println(writers);	
			return;
		}else
		{
			hmReader.put(o.getCharKey(), o);
		}
		
	}
	
	public void process(){
		//while no content on the 
		
		int index=-1;
		String message;
		String writerContent;
		String readerContent;
		for ( String readerKey : hmReader.keySet() ) { 
			for(String writerKey:hmWriter.keySet()){
			
			if(writerKey.equals(readerKey))
			{
				
				System.out.println("The channel detected is......"+writerKey);
				Process o=(Process) hmWriter.get(writerKey);
				Process r=(Process) hmReader.get(readerKey);
				
				hmReader.remove(readerKey);
				
				System.out.println("The process sending output is....."+o.getProcessName());
				hmWriter.remove(writerKey);
				
				index=o.getWriterCharPosition();
				message=o.getContent().substring(index+1).split("\\.")[0];
				update(message,r);
				
				
				//if string contains . 
				writerContent=o.getContent().substring(o.getCharPosition('.')+1);
				readerContent=r.getContent().substring(r.getCharPosition('.')+1);
				o.setContent(writerContent);
				r.setContent(readerContent);
				//System.out.println("Content is....."+r.getContent());
				
				//update(message,r);
				System.out.println("The message sent is....."+message);
				System.out.println("New content.....\n"+writerContent +"\n"+readerContent);
				//System.out.print("The message sent is....."+temp);
				if(writerContent.contains("!")||writerContent.contains("?")){
					this.place(writerContent, o);
					
				}
				if(readerContent.contains("!")||readerContent.contains("?")){
					this.place(readerContent, r);
				}
				
				break;
			}
			}
		}
		
	}
	
	void update(String msg,Process o){
		int index=o.getCharPosition('?');
		String s=o.getContent().substring(index+1);
		System.out.println("......."+s);
		String s1=s.split("\\.")[0];
		
		s.replace(s1, msg);
		o.setContent(s);
		
	}
}
