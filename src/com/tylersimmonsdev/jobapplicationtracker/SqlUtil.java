package com.tylersimmonsdev.jobapplicationtracker;

import com.tylersimmonsdev.dbutil.SqlCredentials;

import java.sql.*;

public class SqlUtil {
    SqlCredentials credentials = new SqlCredentials();

    String url = credentials.getUrl();
    String user = credentials.getUser();
    String password = credentials.getPassword();
    String query = "SELECT * FROM job_application";
    String insertQuery = "INSERT INTO job_application (company_name, job_title, application_status)" +
            " VALUES (\"new test company\", \"software engineer\", \"job offer declined\" );";


    Connection con;



    public void queryTest() {

        {
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                int updateResult = st.executeUpdate(insertQuery);

                System.out.println("In the code after the query");

                System.out.println("Query result for insert: " + updateResult);

//                while (rs.next()) {
//                    System.out.println(String.format("Company: %s, Job Title: %s, Application Status: %s",
//                            rs.getString(2), rs.getString(3), rs.getString(4)));
//                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }


}
