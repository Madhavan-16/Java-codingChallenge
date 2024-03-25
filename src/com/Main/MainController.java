package com.Main;

import java.util.Scanner;
import com.Dao.InsuranceServiceImpl;
import com.Util.DBUtil;
import com.Dao.PolicyService;

public class MainController {

    public static void main(String[] args) {
        InsuranceServiceImpl insuranceService = new InsuranceServiceImpl(DBUtil.getDBConn());
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select option:");
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy");
            System.out.println("3. Get All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    PolicyService.createPolicy(insuranceService);
                    break;
                case 2:
                    PolicyService.getPolicy(insuranceService);
                    break;
                case 3:
                    PolicyService.getAllPolicies(insuranceService);
                    break;
                case 4:
                    PolicyService.updatePolicy(insuranceService);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        DBUtil.dbClose();
        scanner.close();
    }
}
