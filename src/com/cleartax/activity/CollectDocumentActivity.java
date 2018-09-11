package com.cleartax.activity;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.WorkflowAction;

public class CollectDocumentActivity implements WorkflowAction{

	@Override
	public boolean doAction(Applicant Applicant) {
		//Do collect document
		return true;
	}

}
