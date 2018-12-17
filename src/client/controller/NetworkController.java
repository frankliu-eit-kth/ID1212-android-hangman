package client.controller;

import java.io.IOException;
import java.io.Serializable;

import client.net.OutputHandler;
import client.net.ServerConnection;

/**
 * This controller decouples the view from the network layer. All methods, except
 * <code>disconnect</code>, submit their task to the common thread pool, provided by
 * <code>ForkJoinPool.commonPool</code>, and then return immediately.
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
