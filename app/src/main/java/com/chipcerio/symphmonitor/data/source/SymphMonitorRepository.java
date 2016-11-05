package com.chipcerio.symphmonitor.data.source;

import com.chipcerio.symphmonitor.data.Employee;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class SymphMonitorRepository implements SymphMonitorDataSource {
    private static SymphMonitorRepository INSTANCE = null;
    private final SymphMonitorDataSource mFirebaseDataSource;

    private SymphMonitorRepository(SymphMonitorDataSource mFirebaseDataSource) {
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
    public void setEmployeeAsPresent(Employee employee, final SetEmployeePresentCallback mEmployeePresentCallback) {
        mFirebaseDataSource.setEmployeeAsPresent(employee, new SetEmployeePresentCallback() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                mEmployeePresentCallback.onComplete(error, ref);
            }
        });
    }
}
