package se.martin.DBUppgift;

import java.sql.SQLException;
import java.util.List;

public interface WorkRoleDAO {
    void insertWorkRole(WorkRole workRole) throws SQLException;

    void updateWorkRole(WorkRole workRole) throws SQLException;

    void deleteWorkRole(WorkRole workRole) throws SQLException;

    WorkRole getWorkRole(Integer role_id) throws SQLException;

    List<WorkRole> getAllWorkRoles() throws SQLException;
}
