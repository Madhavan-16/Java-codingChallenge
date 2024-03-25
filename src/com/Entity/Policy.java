package com.Entity;

public class Policy {
    
	private int policyId;
    private String policyName;
    private String contactInfo;

    // Constructors
    public Policy() {
    }

    public Policy(int policyId, String policyName, String contactInfo) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // toString method
    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
