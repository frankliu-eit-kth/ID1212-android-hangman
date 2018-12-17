package client.net;

public class StringAppender {
	private String seperator;
	private String s;
	public StringAppender(String seperator) {
		// TODO Auto-generated constructor stub
		this.seperator=seperator;
		this.s="";
	}
	
	public String add(String newString) {
		if(s.equals("")) {
			s=s+newString;
			return s;
		}
		else {
			s=s+seperator+newString;
			return s;
		}
	}
	
	
	@Override
	public String toString() {
		return s;
	}

}
