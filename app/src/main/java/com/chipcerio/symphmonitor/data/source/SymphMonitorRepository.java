package com.chipcerio.symphmonitor.data.source;

import com.chipcerio.symphmonitor.data.Employee;

import java.util.List;

/**
 * Created by clariceann on 05/11/2016.
 */

public class SymphMonitorRepository implements SymphMonitorDataSource {
    private static SymphMonitorRepository INSTANCE = null;
    private final SymphMonitorDataSource mFirebaseDataSource;

    public SymphMonitorRepository(SymphMonitorDataSource mFirebaseDataSource) {
        this.mFirebaseDataSource = mFirebaseDataSource;
    }

    public static SymphMonitorRepository getInstance(SymphMonitorDataSource mFirebaseDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new SymphMonitorRepository(mFirebaseDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getPresent(final AllPresentCallback mAllPresentCallback) {
        mFirebaseDataSource.getPresent(new AllPresentCallback() {
            @Override
            public void onPresentLoaded(List<Employee> employees) {
                mAllPresentCallback.onPresentLoaded(employees);
            }

            @Override
            public void onDataNotAvailable() {
                mAllPresentCallback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void setEmployeeAsPresent(Employee employee) {
        mFirebaseDataSource.setEmployeeAsPresent(employee);
    }
}
