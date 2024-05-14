package com.yahya.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {

    /**
     * "items": [
     *         {
     *             "job_id": "AC_ACCOUNT",
     *             "job_title": "Public Accountant",
     *             "min_salary": 4200,
     *             "max_salary": 9000,
     *             }
     */

    @JsonProperty("job_id")
    private String jobId;
    @JsonProperty("job_title")
    private String jobTitle;
    @JsonProperty("min_salary")
    private int minSalary;
    @JsonProperty("max_salary")
    private int maxSalary;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
}
