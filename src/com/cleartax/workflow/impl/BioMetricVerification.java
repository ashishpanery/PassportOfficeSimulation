package com.cleartax.workflow.impl;

import java.util.List;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.Workflow;
import com.cleartax.workflow.WorkflowAction;

public class BioMetricVerification implements Workflow {
	
	private  List<WorkflowAction> workflowActions;
	
	public BioMetricVerification(List<WorkflowAction> workflows) {
		this.workflowActions = workflows;
	}
	
	@Override
	public boolean processWorkflow(GlobalStagingQueue queue) {
		if(queue.getBioMetricQueue().size()>0) {
			Applicant Applicant = queue.getBioMetricQueue().poll();
			workflowActions.forEach(action -> {
				action.doAction(Applicant);
			});
			queue.getFinishedQueue().add(Applicant);
		}
		return true;
	}

}
