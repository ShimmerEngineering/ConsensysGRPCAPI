package com.shimmerresearch.grpc;


import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;

import com.shimmerresearch.driver.ObjectCluster;
import com.shimmerresearch.driver.Configuration.CHANNEL_UNITS;
import com.shimmerresearch.driverUtilities.ChannelDetails.CHANNEL_TYPE;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerStreamingDummyDataTest {
	private static int port = 50051;
	private static Server server;
	private int count = 1;
	static TestServer serverservice;
	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i =0;i<480000;i++) {
					
						busySleep(125000);
						ObjectCluster objectCluster = new ObjectCluster();
						if (args.length>0) {
							objectCluster.setShimmerName(args[0]);
							objectCluster.setMacAddress(args[0]);
						} else {
							objectCluster.setShimmerName("DummyShimmer");
							objectCluster.setMacAddress("0000");
						}
						//GSR_Skin_Conductance
						//System_Timestamp
						//PPGtoHR
						//Fusion_Response
						objectCluster.addDataToMap("System_Timestamp",CHANNEL_TYPE.CAL.toString(),CHANNEL_UNITS.MILLISECONDS,System.currentTimeMillis());
						objectCluster.addDataToMap("GSR_Skin_Conductance",CHANNEL_TYPE.CAL.toString(),CHANNEL_UNITS.U_SIEMENS,1.0+getRandomNumberUsingInts(1,10)/10.0);
						objectCluster.addDataToMap("PPGtoHR",CHANNEL_TYPE.CAL.toString(),CHANNEL_UNITS.BEATS_PER_MINUTE,getRandomNumberUsingInts(50,60));
						objectCluster.addDataToMap("Fusion_Response",CHANNEL_TYPE.CAL.toString(),CHANNEL_UNITS.NO_UNITS,getRandomNumberUsingInts(0,3));
						
						
						serverservice.sentDataToClient(objectCluster.buildProtoBufMsg());
					
				}
			}
		});
		btnNewButton.setBounds(49, 38, 97, 25);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO Auto-generated method stub
		try {
			serverservice = new TestServer();
			server = ServerBuilder.forPort(port)
					.addService(serverservice)
					.build()
					.start();
			System.out.println("Server Started: " + port);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					// Use stderr here since the logger may has been reset by its JVM shutdown hook.
					System.err.println("*** shutting down gRPC server since JVM is shutting down");
					server.shutdown();
					System.err.println("*** server shut down");
				}
			});
			

			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRandomNumberUsingInts(int min, int max) {
	    Random random = new Random();
	    return random.ints(min, max)
	      .findFirst()
	      .getAsInt();
	}
	
	public static void busySleep(long nanos)
	{
	  long elapsed;
	  final long startTime = System.nanoTime();
	  do {
	    elapsed = System.nanoTime() - startTime;
	  } while (elapsed < nanos);
	}
}
