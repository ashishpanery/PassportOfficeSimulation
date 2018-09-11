package com.cleartax.activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cleartax.beans.Applicant;
import com.cleartax.comparator.FIFSComparator;
import com.cleartax.workflow.Workflow;
import com.cleartax.workflow.impl.GFIFOApplicationProcessorImpl;
import com.cleartax.workflow.impl.GlobalStagingQueue;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		Comparator<Applicant> fifoComparator = new FIFSComparator();
		GlobalStagingQueue queue = new GlobalStagingQueue(new PriorityQueue<>(fifoComparator), 
				new PriorityQueue<>(fifoComparator), 
				new PriorityQueue<>(fifoComparator), new PriorityQueue<>(fifoComparator));
		
		List<Workflow> documentVerificationAgents = new ArrayList<>();
		List<Workflow> policeVerification = new ArrayList<>();
		List<Workflow> bioMetricVerification = new ArrayList<>();
		for(int i = 0; i< 15; i++) {
			documentVerificationAgents.add((Workflow) context.getBean("documentVerificationWorkflow"));
		}
		
		for(int i = 0; i< 10; i++) {
			policeVerification.add((Workflow) context.getBean("policeVerification"));
		}

		for(int i = 0; i<10 ; i++) {
			bioMetricVerification.add((Workflow) context.getBean("bioMetricVerification"));
		}
		
		List<List<Workflow>> workflow = new ArrayList<>(3);
		
		workflow.add(documentVerificationAgents);
		workflow.add(policeVerification);
		workflow.add(bioMetricVerification);
		
		GFIFOApplicationProcessorImpl processor = new GFIFOApplicationProcessorImpl(workflow, queue);
		
		List<Applicant> applicants = new ArrayList<>();
		for(int i =0; i< 180; i++) {
			applicants.add(new Applicant("token-"+i));
		}
		
		processor.processApplicantFlow(applicants);

	}
}

//monika.h@cleartax.com
