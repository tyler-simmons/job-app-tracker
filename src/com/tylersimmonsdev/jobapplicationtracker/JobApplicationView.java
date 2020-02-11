package com.tylersimmonsdev.jobapplicationtracker;

public class JobApplicationView {
    public static void showApplication(String companyName, String jobTitle, String applicationStatus) {
        System.out.println(String.format("Job Application for company: %s\nJob Title: %s\nApplication Status: %s",
                companyName, jobTitle, applicationStatus));
    }
}
