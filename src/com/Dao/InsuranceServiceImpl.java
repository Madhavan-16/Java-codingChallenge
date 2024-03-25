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

    }

