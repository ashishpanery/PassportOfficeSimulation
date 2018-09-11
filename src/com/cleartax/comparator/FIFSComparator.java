package com.cleartax.comparator;

import java.util.Comparator;

import com.cleartax.beans.Applicant;

public class FIFSComparator implements Comparator<Applicant>{

	@Override
	public int compare(Applicant o1, Applicant o2) {
		return (int) (o1.getArrivalTime()-o2.getArrivalTime());
	}

}
