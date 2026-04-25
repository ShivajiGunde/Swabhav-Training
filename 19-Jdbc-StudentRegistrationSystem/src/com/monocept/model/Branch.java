package com.monocept.model;

public class Branch {

	private int branchId;
	private String branchName;

	public Branch(int branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branchId + ", branch_name=" + branchName + "]";
	}

}
