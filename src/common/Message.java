package common;

import client.util.StringAppender;
/**
 * a new class added in this version to reduce the repetition on message handling codes
 * @author Liming Liu
 *
 */
public class Message {
	private int length;
	private MsgType type;
	private String body;
	private String wholeMessage;
	/**
	 * for client side sending message
	 * @param type
	 */
	public Message(MsgType type) {
		// TODO Auto-generated constructor stub
		this.type=type;
		this.length=type.toString().length();
		this.body=null;
		StringAppender sj1=new StringAppender(GlobalConstants.MSG_DELIMETER);
		sj1.add(""+length);
		sj1.add(this.type.toString());
		this.wholeMessage=sj1.toString();
	}
	/**
	 * for client sending input and server sending game message
	 * @param type
	 * @param body
	 */
	public Message(MsgType type, String body) {
		this.type=type;
		this.body=body;
		StringAppender sj1=new StringAppender(GlobalConstants.MSG_DELIMETER);
		sj1.add(this.type.toString());
		sj1.add(this.body);
		
		this.length=sj1.toString().length();
		StringAppender sj2=new StringAppender(GlobalConstants.MSG_DELIMETER);
		sj2.add(""+this.length);
		sj2.add(sj1.toString());
		this.wholeMessage=sj2.toString();
	}
	/**
	 * for receiving, check the length header and create new message
	 * @param wholeMessage
	 */
	public Message(String wholeMessage) {
		this.wholeMessage=wholeMessage;
		String[] msgParts=wholeMessage.split(GlobalConstants.MSG_DELIMETER);
		this.length=Integer.parseInt(msgParts[GlobalConstants.MSG_LENGTH_INDEX]);
		if(this.length>this.wholeMessage.length()-
				msgParts[GlobalConstants.MSG_LENGTH_INDEX].length()-GlobalConstants.MSG_DELIMETER.length()) {
			System.out.println("received incomplete message");
			System.out.println(wholeMessage);
		}
		String tempType=msgParts[GlobalConstants.MSG_TYPE_INDEX];
		if(tempType.equals("USER_INPUT")) {
			this.type=MsgType.USER_INPUT;
			
		}
		if(tempType.equals("USER")) {
			this.type=MsgType.USER_INPUT;
			
		}
		if(tempType.equals("USER_INPUT")) {
			this.type=MsgType.USER;
			
		}
		if(tempType.equals("DISCONNECT")) {
			this.type=MsgType.DISCONNECT;
			
		}
		if(tempType.equals("START")) {
			this.type=MsgType.START;
			
		}
		if(tempType.equals("SERVERMSG")) {
			this.type=MsgType.SERVERMSG;
			
		}
		if(this.type==null) {
			System.out.println("cannnot identify message type");
			System.out.println(wholeMessage);
			return;
		}
		
		if(msgParts.length==3) {
			this.body=msgParts[GlobalConstants.MSG_BODY_INDEX];
		}else {
			this.body=null;
		}
	}
	public String getBody() {
		return this.body;
	}
	public String getWholeMessage() {
		return this.wholeMessage;
	}
	public MsgType getType() {
		return this.type;
	}

}
