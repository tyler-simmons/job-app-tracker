package com.tylersimmonsdev.jobapplicationtracker;

//sql information
//company_name, job_title, application_status

import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.conf.ConnectionUrlParser;
import com.tylersimmonsdev.dbutil.QueryBuilder;
import com.tylersimmonsdev.dbutil.SqlCredentials;
import com.tylersimmonsdev.dbutil.QueryPair;


public class JobApplication {
    private int id;
    private String companyName;
    private String jobTitle;
    private String applicationStatus;
    //private Connection conn;


    public JobApplication() {
        this.companyName = null;
        this.jobTitle = null;
        this.applicationStatus = null;
    }

    public JobApplication(String companyName, String jobTitle, String applicationStatus) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.applicationStatus = applicationStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void updateApplicationStatus(String newStatus) {
        this.applicationStatus = newStatus;
    }

    //returns true if no null properties
    public boolean hasValidProperties() {
        return !(companyName == null || jobTitle == null || applicationStatus == null);
    }

    //Create
    public int saveToDatabase() {
        Connection conn;
        SqlCredentials credentials = new SqlCredentials();

        if (!this.hasValidProperties()) {
            System.out.println("Error: trying to save JobApplication object to database with null properties");
            return -1;
        }
        String saveQuery = String.format("INSERT INTO job_application " +
                "(company_name, job_title, application_status) " +
                "VALUES " +
                "(\"%s\",\"%s\",\"%s\");", companyName, jobTitle, applicationStatus);

        try {
            conn = DriverManager.getConnection(credentials.getUrl(), credentials.getUser(), credentials.getPassword());
            Statement st = conn.createStatement();
            int insertQueryResult = st.executeUpdate(saveQuery);

            if (insertQueryResult < 1) {
                System.out.println("Error saving to the database ???");
            } else {
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return -1;
    }

    //Read
    public static ArrayList<JobApplication> findAll() {
        Connection conn;
        ArrayList<JobApplication> jobList = new ArrayList<JobApplication>();
        SqlCredentials credentials = new SqlCredentials();

        String query = QueryBuilder.selectQuery("*", "job_application");

        try {
            conn = DriverManager.getConnection(credentials.getUrl(), credentials.getUser(), credentials.getPassword());
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                JobApplication tempJobApplication = new JobApplication(rs.getString(2), rs.getString(3), rs.getString(4));
                jobList.add(tempJobApplication);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return jobList;
    }

    public static JobApplication findOne(QueryPair constraint) {
        Connection conn;
        JobApplication j;
        SqlCredentials credentials = new SqlCredentials();
        ResultSet rs;

        String query = String.format("SELECT * FROM job_application where %s=\"%s\"", constraint.getKey(),constraint.getValue());

        try {
            conn = DriverManager.getConnection(credentials.getUrl(), credentials.getUser(), credentials.getPassword());
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                j = new JobApplication(rs.getString(2), rs.getString(3), rs.getString(4));
                return j;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new JobApplication();

    }

    //Update
    public int update() {

        return -1;
    }

    public String toString() {
        return String.format("Company: %s, Job Title: %s, Status: %s", this.companyName, this.jobTitle, this.applicationStatus);
    }

}
