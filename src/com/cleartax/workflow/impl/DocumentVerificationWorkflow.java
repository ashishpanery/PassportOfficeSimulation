package com.cleartax.workflow.impl;

import java.util.List;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.Workflow;
import com.cleartax.workflow.WorkflowAction;

public class DocumentVerificationWorkflow implements Workflow {

	private  List<WorkflowAction> workflowActions;
	
	public DocumentVerificationWorkflow(List<WorkflowAction> workflows) {
		this.workflowActions = workflows;
	}
	
	@Override
	public boolean processWorkflow(GlobalStagingQueue queue) {
		if(queue.getInitialQueue().size()>0) {
			Applicant Applicant = queue.getInitialQueue().poll();
			workflowActions.forEach(action -> {
				action.doAction(Applicant);
			});
			queue.getPoliceVerificationQueue().add(Applicant);
		}
		
		return true;
	}

}
