package com.chipcerio.symphmonitor.data.source;

import com.chipcerio.symphmonitor.data.Employee;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public interface SymphMonitorDataSource {

    /*  https://firebase.google.com/docs/reference/android/com/google/firebase/database/DatabaseReference.CompletionListener
        This method will be triggered when the operation has either succeeded or failed.
        If it has failed, an error will be given.
        If it has succeeded, the error will be null
     */
    interface SetEmployeePresentCallback {
        void onComplete(DatabaseError error, DatabaseReference ref);
    }

    void setEmployeeAsPresent(Employee employee, SetEmployeePresentCallback mEmployeePresentCallback);
}