package piEngine;

public class Process {
	String processName;
	String content;
	
	public Process(String processName,String content){
	this.processName=processName;
	this.content=content;
	}
	
	public String getProcessName(){
		return processName;
	}

	public String getContent(){
		return content;
	}
	
	
	public void setProcesName(String name){
		this.processName=name;			
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	
	
	public int getReadCharPosition(){
		
		int index = -1;
		char[] c1=this.getContent().toCharArray();
		for(int i=0;i<c1.length;i++){
			if(c1[i]=='?'){
				index=i;
				break;
			}
			
		}
		return index;
		
	}
	
public int getWriterCharPosition(){
		
		int index = -1;
		char[] c1=this.getContent().toCharArray();
		for(int i=0;i<c1.length;i++){
			if(c1[i]=='!'){
				index=i;
				break;
			}
			
		}
		return index;
		
	}
	

public String getWriterChar(){
	String s1 = " ";
	if(this.getWriterCharPosition()!=-1){
	s1=this.getContent().substring(0, this.getWriterCharPosition());
	}
	return s1;
	
}
	public String getCharKey(){
		String s1 = " ";
		if(this.getReadCharPosition()!=-1){
		s1=this.getContent().substring(0, this.getReadCharPosition());
		}
		return s1;
	}
	
	
public int getCharPosition(char c){
	int index = -1;
	char[] c1=this.getContent().toCharArray();
	for(int i=0;i<c1.length;i++){
		if(c1[i]==c){
			index=i;
			break;
		}
		
	}
	return index;
}
	
}
