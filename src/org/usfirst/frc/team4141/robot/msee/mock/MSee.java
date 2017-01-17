package org.usfirst.frc.team4141.robot.msee.mock;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;



public class MSee implements ServiceDiscoveryHandler  {
	WebSocketClient client;
	
	public MSee() {
		super();
	}


	@Override
	public synchronized void onServiceFound(String name, String address, int port) {
    	System.out.printf("MSee sees service: %s@%s:%d\n", name,address,port);
    	String dest = "ws://"+address+":"+port;
    	System.out.printf("uri: %s\n", dest);

        client = new WebSocketClient();
    	RobotSocketClient robot;
		robot = new RobotSocketClient();
        try
        {
            client.start();
            URI destUri = new URI(dest);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(robot,destUri,request);
            System.out.printf("Connecting to : %s%n",destUri);
           

            
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }    	

	
    public static void main(String[] args) throws InterruptedException  {
    	
    	ExecutorService executorService = Executors.newSingleThreadExecutor();

    	MSee msee = new MSee();
    	
    	executorService.execute(new RobotServiceListener(msee));

        Thread.sleep(8000);
        System.out.println("Exiting ... ");

    	executorService.shutdown();
    	
    	msee.close();

    }


	public void close() {
    	if(client!=null){
			try
	        {
	           client.stop();
	        }
	        catch (Exception e)
	        {
	           e.printStackTrace();
	        }
    	}
	}
}
