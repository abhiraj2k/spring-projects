package com.springboot.springbootdemo.util;

import java.util.Date;

import com.springboot.springbootdemo.model.Worker;

public class HelperMethods {
    public static Worker getWorkerFromParams(int workerId, String firstName, String lastName, String salary,
            Date joiningDate, String department, String email) {
        return new Worker(workerId, firstName, lastName, salary, joiningDate, department, email);
    }

}
