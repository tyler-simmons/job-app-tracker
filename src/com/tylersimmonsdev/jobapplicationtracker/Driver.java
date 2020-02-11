package com.tylersimmonsdev.jobapplicationtracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.tylersimmonsdev.dbutil.QueryBuilder;
import com.tylersimmonsdev.dbutil.QueryPair;


public class Driver {
    public static void main(String[] args) {
//        SqlUtil s = new SqlUtil();
////
////        s.queryTest();

//        JobApplication testApp = new JobApplication("Auto test company", "QA Engineer", "Applied");
//        testApp.saveToDatabase();

//        ArrayList<JobApplication> test = JobApplication.findAll();
//        for (JobApplication j : test) {
//            System.out.println(j.toString());
//        }

        JobApplication test = JobApplication.findOne(new QueryPair<String, String>("company_name", "Level One LLC"));
        System.out.println(test.toString());







//
    }
}
