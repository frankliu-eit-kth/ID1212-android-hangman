package client.controller;

import java.io.IOException;
import java.io.Serializable;

import client.net.OutputHandler;
import client.net.ServerConnection;

/**
 * Exact same code as Hangman Game project
 */
public class NetworkController {
    public static final ServerConnection serverConnection = new ServerConnection();

    /**
     * @see ServerConnection#connect(java.lang.String, int,
     * textprotocolchat.client.net.OutputHandler)
     */
    public static void connect(String host, int port ) throws Exception{
    	serverConnection.connect(host, port);
    }
    
    public static boolean checkConnection() {
    	return serverConnection.isConnected();
    }

    /**
     * @see ServerConnection#disconnect() Blocks until disconnection is completed.
     */
    public static void disconnect() throws IOException {
        serverConnection.disconnect();
    }
    
    public static void start(){
    	serverConnection.sendStart();
    }
    /**
     * @see ServerConnection#sendUsername(java.lang.String)
     */
    public static void sendUsername(String username,OutputHandler outputHandler) {
        serverConnection.sendUsername(username,outputHandler);
        
        
    }

    /**
     * @see ServerConnection#sendChatEntry(java.lang.String)
     */
    public static void sendInput(String input) {
        serverConnection.sendInput(input);
    }
}
