package se.martin.DBUppgift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkRoleDAOImpl implements WorkRoleDAO {

    @Override
    public void insertWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        try {
            conn = JDBCUtil.getConnection();

            String sql = """
                    INSERT INTO work_role (title, description, salary, creation_date)
                    VALUES(?, ?, ?, ?);
                    """;

            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, workRole.getTitle());
            pStmt.setString(2, workRole.getDescription());
            pStmt.setDouble(3, workRole.getSalary());
            pStmt.setDate(4, workRole.getCreation_date());

            int rowsAffected = pStmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            JDBCUtil.commit(conn);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void updateWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, workRole.getTitle());
            pStmt.setString(2, workRole.getDescription());
            pStmt.setDouble(3, workRole.getSalary());
            pStmt.setDate(4, workRole.getCreation_date());
            pStmt.setInt(5, workRole.getRole_id());

            int rowsAffected = pStmt.executeUpdate();
            JDBCUtil.commit(conn);

            if (rowsAffected == 0) {
                System.out.println("Role ID " + workRole.getRole_id() + " does not exist");
            } else {
                System.out.println("Role ID " + workRole.getRole_id() + " has been updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void deleteWorkRole(WorkRole workRole) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM work_role WHERE role_id = ?";
            pStmt = conn.prepareStatement(sql);

            pStmt.setInt(1, workRole.getRole_id());

            int rowsAffected = pStmt.executeUpdate();
            JDBCUtil.commit(conn);

            if (rowsAffected == 0) {
                System.out.println("Role ID " + workRole.getRole_id() + " does not exist");
            } else {
                System.out.println("Role ID " + workRole.getRole_id() + " has been deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public WorkRole getWorkRole(Integer role_id) throws SQLException {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        WorkRole workRole = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM work_role WHERE role_id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, role_id);
            rs = pStmt.executeQuery();

            if(rs.next()) {
                Integer id = rs.getInt("role_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Double salary = rs.getDouble("salary");
                Date creation_date = rs.getDate("creation_date");

                workRole = new WorkRole(role_id, title, description, salary, creation_date);

            } else {
                System.out.println("Role ID " + role_id + " does not exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }

        return workRole;
    }

    @Override
    public List<WorkRole> getAllWorkRoles() throws SQLException {
        List<WorkRole> allRoles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM work_role";
            pStmt = conn.prepareStatement(sql);
            rs = pStmt.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("role_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Double salary = rs.getDouble("salary");
                Date creation_date = rs.getDate("creation_date");
                WorkRole workRole = new WorkRole(id, title, description, salary, creation_date);
                allRoles.add(workRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(pStmt);
            JDBCUtil.closeConnection(conn);
        }

        return allRoles;
    }
}



