package se.martin.DBUppgift;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.*;

public class WorkRoleDAOTests {

    @AfterEach
    public void cleanUp() {
        Connection conn = null;
        PreparedStatement pStmt = null;
        try {
            conn = JDBCUtil.getConnection();
            pStmt = conn.prepareStatement("DROP TABLE IF EXISTS work_role");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }


    @Test
    public void testConnectionIsOk(){
        try{
            JDBCUtil.getConnection();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testVerifyAddedWorkRole(){
        WorkRoleDAO workRoleDAO = new WorkRoleDAOImpl();

        WorkRole workRole = new WorkRole("Systemutvecklare",
                "Programmerar", 30000.00,
                java.sql.Date.valueOf("2024-12-14"));

        List<WorkRole> allRoles = new ArrayList<>();
        try {
            workRoleDAO.insertWorkRole(workRole);

            allRoles = new WorkRoleDAOImpl().getAllWorkRoles();
            System.out.println("All Work Roles:");
            for (WorkRole role : allRoles) {
                System.out.println(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1, allRoles.size());
    }
}
