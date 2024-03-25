package com.Dao;

import com.Entity.Policy;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class InsuranceServiceImpl implements IPolicyService {
    private Connection conn;

    
    public InsuranceServiceImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean createPolicy(Policy policy) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO policy (policyId, policyName, contactInfo) VALUES (?, ?, ?)");
            pstmt.setInt(1, policy.getPolicyId());
            pstmt.setString(2, policy.getPolicyName());
            pstmt.setString(3, policy.getContactInfo());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Policy getPolicy(int policyId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM policy WHERE policyId = ?");
            pstmt.setInt(1, policyId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Policy policy = new Policy();
                policy.setPolicyId(rs.getInt("policyId"));
                policy.setPolicyName(rs.getString("policyName"));
                policy.setContactInfo(rs.getString("contactInfo"));
                return policy;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        Collection<Policy> policies = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM policy");

            while (rs.next()) {
                Policy policy = new Policy();
                policy.setPolicyId(rs.getInt("policyId"));
                policy.setPolicyName(rs.getString("policyName"));
                policy.setContactInfo(rs.getString("contactInfo"));
                policies.add(policy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE policy SET policyName = ?, contactInfo = ? WHERE policyId = ?");
            pstmt.setString(1, policy.getPolicyName());
            pstmt.setString(2, policy.getContactInfo());
            pstmt.setInt(3, policy.getPolicyId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

