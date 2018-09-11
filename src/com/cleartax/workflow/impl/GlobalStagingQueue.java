package com.cleartax.workflow.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.cleartax.beans.Applicant;

public class GlobalStagingQueue {

	PriorityQueue<Applicant> initialQueue;
	
	PriorityQueue<Applicant> policeVerificationQueue;
	
	PriorityQueue<Applicant> bioMetricQueue;
	
	List<Applicant> finishedQueue;
	

	public GlobalStagingQueue(PriorityQueue<Applicant> initialQueue, 
			PriorityQueue<Applicant> policeVerificationQueue,
			PriorityQueue<Applicant> bioMetricQueue,
			PriorityQueue<Applicant> finishedQueue
			
			) {
		super();
		this.initialQueue = initialQueue;
		this.policeVerificationQueue = policeVerificationQueue;
		this.bioMetricQueue = bioMetricQueue;
		this.finishedQueue = new ArrayList<>();
	}

	public PriorityQueue<Applicant> getInitialQueue() {
		return initialQueue;
	}

	public void setInitialQueue(PriorityQueue<Applicant> initialQueue) {
		this.initialQueue = initialQueue;
	}

	public PriorityQueue<Applicant> getPoliceVerificationQueue() {
		return policeVerificationQueue;
	}

	public void setPoliceVerificationQueue(PriorityQueue<Applicant> policeVerificationQueue) {
		this.policeVerificationQueue = policeVerificationQueue;
	}

	public PriorityQueue<Applicant> getBioMetricQueue() {
		return bioMetricQueue;
	}

	public void setBioMetricQueue(PriorityQueue<Applicant> bioMetricQueue) {
		this.bioMetricQueue = bioMetricQueue;
	}
	
	
	public List<Applicant> getFinishedQueue() {
		return finishedQueue;
	}

	public void setFinishedQueue(List<Applicant> finishedQueue) {
		this.finishedQueue = finishedQueue;
	}
	
	public boolean isCompleted() {
		return (initialQueue.size()>0 || policeVerificationQueue.size()>0|| bioMetricQueue.size()>0);
	}

	public void printCurrentState() {
		System.out.println("Waiting for Document Verification="+initialQueue.size());
		System.out.println("Waiting for Police Verification="+policeVerificationQueue.size());
		System.out.println("Waiting for Bio Metric Verification="+bioMetricQueue.size());
		System.out.println("Completed Verification="+finishedQueue.size());
		System.out.println("------");
	}
	
}
