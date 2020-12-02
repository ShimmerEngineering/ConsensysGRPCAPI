package com.shimmerresearch.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.shimmerresearch.grpc.ShimmerGRPC.CommandStatus;
import com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2;
import com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class TestServer extends ShimmerServerGrpc.ShimmerServerImplBase {
	private List<StreamObserver<ObjectCluster2>> mResponseObserverList=Collections.synchronizedList(new ArrayList<StreamObserver<ObjectCluster2>>());

	@Override
	public void getDataStream(StreamRequest request,
			StreamObserver<ObjectCluster2> responseObserver) {
		// TODO Auto-generated method stub
		mResponseObserverList.add(responseObserver);
	}

	public void sentDataToClient(ObjectCluster2 ojc) {
		for (StreamObserver<ObjectCluster2> so:mResponseObserverList){
			if (so!=null){
				try{
					so.onNext(ojc);
				} catch (StatusRuntimeException sre){
					if (((StatusRuntimeException) sre).getStatus()==Status.CANCELLED){
						mResponseObserverList.remove(so);
					}
				}
			}
		}
	}




}
