package com.tylersimmonsdev.dbutil;

public class SqlCredentials {
    private final String url = "jdbc:mysql://localhost:3306/job_app_demo";
    private final String user = "jobuser";
    private final String password = "jobpassword";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
