package com.cleartax.activity;

import com.cleartax.beans.Applicant;
import com.cleartax.workflow.WorkflowAction;

public class CollectPhotoIdProofActivity implements WorkflowAction {

	@Override
	public boolean doAction(Applicant Applicant) {
		// check attested activity.
		return true;
	}

}
