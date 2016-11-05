package com.chipcerio.symphmonitor.data.source.remote;

import com.chipcerio.symphmonitor.data.Employee;
import com.chipcerio.symphmonitor.data.source.SymphMonitorDataSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by clariceann on 05/11/2016.
 */

public class SymphMonitorFirebaseDataSource implements SymphMonitorDataSource {

    private static SymphMonitorFirebaseDataSource INSTANCE = null;

    private DatabaseReference mRef;

    public static SymphMonitorFirebaseDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SymphMonitorFirebaseDataSource();
        }
        return INSTANCE;
    }

    public void destoryInstance() {
        INSTANCE = null;
    }

    private SymphMonitorFirebaseDataSource() {
        mRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void setEmployeeAsPresent(Employee employee, final SetEmployeePresentCallback mEmployeePresentCallback) {
        DatabaseReference ref = mRef.child("Employees");

        String key = ref.push().getKey();
        ref.child(key).setValue(employee, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                mEmployeePresentCallback.onComplete(databaseError, databaseReference);
            }
        });
    }
}
