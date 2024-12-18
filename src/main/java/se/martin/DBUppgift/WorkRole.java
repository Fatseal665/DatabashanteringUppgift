package se.martin.DBUppgift;

import java.sql.Date;
import java.util.Objects;

public class WorkRole {
    private Integer role_id;
    private String title;
    private String description;
    private double salary;
    private java.sql.Date creation_date;


    //Getter, Setter
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }



    //Equals, hashcode och toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkRole workRole = (WorkRole) o;
        return Double.compare(salary, workRole.salary) == 0 && Objects.equals(role_id, workRole.role_id) && Objects.equals(title, workRole.title) && Objects.equals(description, workRole.description) && Objects.equals(creation_date, workRole.creation_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, title, description, salary, creation_date);
    }

    @Override
    public String toString() {
        return String.format("Role ID: %d\nTitle: %s\nDescription: %s\nSalary: %.2f\nCreated: %s\n",
                role_id, title, description, salary, creation_date);
    }



    //Konstruktor för objektet WorkRole
    public WorkRole(String title, String description, double salary,
                    java.sql.Date creation_date) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }

    public WorkRole(Integer role_id, String title, String description, double salary,
                    java.sql.Date creation_date) {
        this.role_id = role_id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creation_date = creation_date;
    }
}
