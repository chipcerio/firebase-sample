package com.chipcerio.symphmonitor.data.source.remote;

import android.support.test.runner.AndroidJUnit4;

import com.chipcerio.symphmonitor.data.Employee;
import com.chipcerio.symphmonitor.data.source.SymphMonitorDataSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class SymphMonitorFirebaseDataSourceTest {

    private SymphMonitorFirebaseDataSource mFirebaseDataSource;

    @Before
    public void setUp() throws Exception {
        mFirebaseDataSource = SymphMonitorFirebaseDataSource.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        mFirebaseDataSource.destoryInstance();
    }

    @Test
    public void setEmployeeAsPresentAndCheckIfItSucceeded() throws Exception {
        Employee employee = new Employee("Arth Limchiu");

        mFirebaseDataSource.setEmployeeAsPresent(employee, new SymphMonitorDataSource.SetEmployeePresentCallback() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                assertNull(error);
            }
        });
    }

    @Test
    public void setEmployeeAsPresentAndCheckIfItDidntSucceed() throws Exception {
        Employee employee = new Employee("Arth Limchiu");

        mFirebaseDataSource.setEmployeeAsPresent(employee, new SymphMonitorDataSource.SetEmployeePresentCallback() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                assertNotNull(error);
            }
        });
    }
}