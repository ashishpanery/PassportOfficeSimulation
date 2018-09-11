package com.cleartax.workflow;

import com.cleartax.workflow.impl.GlobalStagingQueue;

public interface Workflow {

	public boolean processWorkflow(GlobalStagingQueue queue);
}
