package com.chipcerio.symphmonitor.data.source;

import com.chipcerio.symphmonitor.data.Employee;

import java.util.List;

/**
 * Created by clariceann on 05/11/2016.
 */
public interface SymphMonitorDataSource {

    interface AllPresentCallback {

        void onPresentLoaded(List<Employee> employees);
        void onDataNotAvailable();

    }

    void getPresent(AllPresentCallback mAllPresentCallback);

    void setEmployeeAsPresent(Employee employee);
}
