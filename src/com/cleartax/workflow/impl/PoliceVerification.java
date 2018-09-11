package com.cleartax.workflow.impl;

import java.util.List;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.Workflow;
import com.cleartax.workflow.WorkflowAction;

public class PoliceVerification implements Workflow {
	
	private List<WorkflowAction> workflowActions;
	
	public PoliceVerification(List<WorkflowAction> workflows) {
		this.workflowActions = workflows;
	}
	
	@Override
	public boolean processWorkflow(GlobalStagingQueue queue) {
		if(queue.getPoliceVerificationQueue().size()>0) {
			Applicant Applicant = queue.getPoliceVerificationQueue().poll();
			workflowActions.forEach(action -> {
				action.doAction(Applicant);
			});
			queue.getBioMetricQueue().add(Applicant);
		}
		return true;
	}
}
