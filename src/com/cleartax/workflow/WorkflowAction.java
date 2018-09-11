package com.cleartax.workflow;

import com.cleartax.beans.Applicant;

public interface WorkflowAction {

	public boolean doAction(Applicant Applicant);
}
