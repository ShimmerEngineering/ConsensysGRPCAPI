package com.shimmerresearch.grpc;

import com.shimmerresearch.driver.BasicProcessWithCallBack;
import com.shimmerresearch.driver.ObjectCluster;
import com.shimmerresearch.driver.ShimmerMsg;

import com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2;
import com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ServiceClient extends BasicProcessWithCallBack{
	private final ManagedChannel channel;
	private final ShimmerServerGrpc.ShimmerServerStub stub;
	
	public ServiceClient(String host, int port) {
		  channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		  stub = ShimmerServerGrpc.newStub(channel);
		  
StreamRequest sreq = StreamRequest.newBuilder().setMessage("All").build();
		  
		  
		   //Receiving Data from the server
		  stub.getDataStream(sreq, new StreamObserver<ObjectCluster2>(){

			@Override
			public void onNext(ObjectCluster2 value) {
				// TODO Auto-generated method stub
				ObjectCluster ojc = new ObjectCluster(value);
				sendCallBackMsg(1, ojc);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		  
		  });
		 
	}
	
	@Override
	protected void processMsgFromCallback(ShimmerMsg shimmerMSG) {
		// TODO Auto-generated method stub
		
	}
}
