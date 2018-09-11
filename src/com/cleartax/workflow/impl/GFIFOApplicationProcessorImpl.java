package com.cleartax.workflow.impl;

import java.util.List;
import java.util.Map;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.ApplicationProcessor;
import com.cleartax.workflow.Workflow;

public class GFIFOApplicationProcessorImpl implements ApplicationProcessor{

	
	GlobalStagingQueue globalStagingQueue;
	
	List<List<Workflow>> workflows;
	
	public GFIFOApplicationProcessorImpl(List<List<Workflow>> workflow, GlobalStagingQueue globalStagingQueue) {
		this.workflows = workflow;
		this.globalStagingQueue = globalStagingQueue;
	}
	
	@Override
	public boolean processApplicantFlow(List<Applicant> applicant) {
		
			pushApplicationInIntialQueue(applicant);
			
			globalStagingQueue.printCurrentState();
			while(
				(globalStagingQueue.getInitialQueue().size()>0 ||
						globalStagingQueue.getPoliceVerificationQueue().size()>0||
						globalStagingQueue.getBioMetricQueue().size() >0)) {
				if(globalStagingQueue.getInitialQueue().size()> 0) {
					List<Workflow> availableWorkflow = workflows.get(0);
					availableWorkflow.forEach(workflow->{
						workflow.processWorkflow(globalStagingQueue);
					});
				}
				if(globalStagingQueue.getPoliceVerificationQueue().size()>0) {
					List<Workflow> policeVarificationWorkflows = workflows.get(1);
					policeVarificationWorkflows.forEach(workflow->{
						workflow.processWorkflow(globalStagingQueue);
					});
				}
			
				if(globalStagingQueue.getBioMetricQueue().size()>0) {
					List<Workflow> availableWorkflow = workflows.get(2);
					availableWorkflow.forEach(workflow->{
						workflow.processWorkflow(globalStagingQueue);
					});
				}
		
			
				globalStagingQueue.printCurrentState();
			}
			globalStagingQueue.printCurrentState();
		return false;
		
		
	}
	
	public void pushApplicationInIntialQueue(List<Applicant> applicants) {
		applicants.forEach(applicant->{
			globalStagingQueue.getInitialQueue().add(applicant);
		});
	}
	
//9964946758- Sid.
}
