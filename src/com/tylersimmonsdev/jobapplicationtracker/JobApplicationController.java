package com.tylersimmonsdev.jobapplicationtracker;

public class JobApplicationController {
    private JobApplication model;
    private JobApplicationView view;

    public JobApplicationController(JobApplication jobApplication, JobApplicationView jobApplicationView) {
        this.model = jobApplication;
        this.view = jobApplicationView;
    }

    public void setCompanyName(String companyName) {
        model.setCompanyName((companyName));
    }

    public String getCompanyName() {
        return model.getCompanyName();
    }

    public void setJobTitle(String jobTitle) {
        model.setJobTitle(jobTitle);
    }

    public void updateJobStatus(String newStatus) {
        model.updateApplicationStatus(newStatus);
    }

    public void updateView() {
        view.showApplication(model.getCompanyName(), model.getJobTitle(), model.getApplicationStatus());
    }

    public String getJobStatus() {
        return model.getApplicationStatus();
    }

}
