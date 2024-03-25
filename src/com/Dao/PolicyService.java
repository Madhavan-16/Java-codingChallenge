package com.Dao;

import java.util.Collection;
import java.util.Scanner;
import com.Dao.InsuranceServiceImpl;
import com.Entity.Policy;
import com.Exception.*;

public class PolicyService {
    
    public static void createPolicy(InsuranceServiceImpl insuranceService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter policy name: ");
        String policyName = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        Policy newPolicy = new Policy();
        newPolicy.setPolicyName(policyName);
        newPolicy.setContactInfo(contactInfo);

        boolean success = insuranceService.createPolicy(newPolicy);
        if (success) {
            System.out.println("Policy created successfully.");
        } else {
            System.out.println("Failed to create policy.");
        }
    }

    public static void getPolicy(InsuranceServiceImpl insuranceService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter policy ID: ");
        int policyId = scanner.nextInt();
        Policy policy = insuranceService.getPolicy(policyId);
        if (policy != null) {
            System.out.println("Policy details:");
            System.out.println(policy);
        } else {
            try {
                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
            } catch (PolicyNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void getAllPolicies(InsuranceServiceImpl insuranceService) {
        Collection<Policy> policies = insuranceService.getAllPolicies();
        if (!policies.isEmpty()) {
            System.out.println("All policies:");
            for (Policy policy : policies) {
                System.out.println(policy);
            }
        } else {
            try {
                throw new PolicyNotFoundException("No policies found.");
            } catch (PolicyNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void updatePolicy(InsuranceServiceImpl insuranceService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter policy ID to update: ");
        int policyId = scanner.nextInt();
        Policy policyToUpdate = insuranceService.getPolicy(policyId);
        if (policyToUpdate != null) {
            System.out.print("Enter updated policy name: ");
            String updatedPolicyName = scanner.next();
            policyToUpdate.setPolicyName(updatedPolicyName);

            System.out.print("Enter updated contact info: ");
            String updatedContactInfo = scanner.next();
            policyToUpdate.setContactInfo(updatedContactInfo);

            boolean success = insuranceService.updatePolicy(policyToUpdate);
            if (success) {
                System.out.println("Policy updated successfully.");
            } else {
                System.out.println("Failed to update policy.");
            }
        } else {
            try {
                throw new PolicyNotFoundException("Policy not found.");
            } catch (PolicyNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
