package com.cleartax.workflow;

import java.util.List;

import com.cleartax.beans.Applicant;

public interface ApplicationProcessor {

	public boolean processApplicantFlow(List<Applicant> applicant);
	
}
