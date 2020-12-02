package com.shimmerresearch.grpc;


import java.util.Collection;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import com.shimmerresearch.driver.BasicProcessWithCallBack;
import com.shimmerresearch.driver.FormatCluster;
import com.shimmerresearch.driver.ObjectCluster;
import com.shimmerresearch.driver.ShimmerMsg;

public class ClientTestExample extends BasicProcessWithCallBack {

	ServiceClient client;
	int count = 0;
	DescriptiveStatistics mStats = new DescriptiveStatistics();
	DescriptiveStatistics mStatsTS = new DescriptiveStatistics();
	double lts = -1;
	public static void main(String[] args) throws InterruptedException {
		
		ClientTestExample example = new ClientTestExample();
		example.initialize();
		
	}
	
	public void initialize() {
		client = new ServiceClient("localhost",50051);
		setWaitForData(client);
	}

	@Override
	protected void processMsgFromCallback(ShimmerMsg shimmerMSG) {
		// TODO Auto-generated method stub
		if (shimmerMSG.mB instanceof ObjectCluster) {
			count++;
			ObjectCluster ojc = (ObjectCluster)shimmerMSG.mB;
			Collection<FormatCluster> tsFormats = ojc.getCollectionOfFormatClusters("System_Timestamp");
			FormatCluster format = ((FormatCluster)ObjectCluster.returnFormatCluster(tsFormats,"CAL")); // retrieve the calibrated data
			double ts = format.mData;
			double delay = System.currentTimeMillis()-ts;
			mStats.addValue(delay);
			if (lts!=-1) {
				mStatsTS.addValue(ts-lts);
			}
			lts = ts; 
			if (count%48000==0) {
				System.out.println("Packet Count Received:" + count + " ; Avg Delay :" + mStats.getMean() + "(ms); OJC Time Delay: " + mStatsTS.getMean() + "(ms)");
			}
		}
	}
}
