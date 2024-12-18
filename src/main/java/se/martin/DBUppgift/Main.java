package se.martin.DBUppgift;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WorkRoleDAO workRoleDAO = new WorkRoleDAOImpl();

        //Work roles
        WorkRole systDev = new WorkRole("Systemutvecklare",
                "Skapar och utvecklar applikationer", 30000.00,
                java.sql.Date.valueOf("2024-12-14"));

        WorkRole baker = new WorkRole("Bagare",
                "Bakar bröd", 21000.00,
                java.sql.Date.valueOf("2015-03-27"));

        WorkRole mailMan = new WorkRole("Brevbärare",
                "Levererar brev", 15000.00,
                java.sql.Date.valueOf("2020-09-15"));

        WorkRole teacher = new WorkRole("Lärare",
                "Undervisar", 30000.00,
                java.sql.Date.valueOf("2005-01-23"));


        //Insert work role
        try {
            workRoleDAO.insertWorkRole(mailMan);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //Update work role
//        try {
//            WorkRole workRole = workRoleDAO.getWorkRole(1);
//            workRole.setDescription("Programmerar");
//            workRole.setSalary(50000.00);
//            workRoleDAO.updateWorkRole(workRole);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //Delete work role
//        try {
//            WorkRole workRole = workRoleDAO.getWorkRole(0);
//            workRoleDAO.deleteWorkRole(workRole);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //Show work role
//        try {
//            WorkRole workRole = workRoleDAO.getWorkRole(1);
//            System.out.println(workRole);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


       //Show all work roles
//        try {
//            List<WorkRole> allRoles = new WorkRoleDAOImpl().getAllWorkRoles();
//            System.out.println("All Work Roles:");
//            for (WorkRole role : allRoles) {
//                System.out.println(role);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }
}