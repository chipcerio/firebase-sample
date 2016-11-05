package com.chipcerio.symphmonitor.secondscreensamp;

import com.chipcerio.symphmonitor.R;
import com.chipcerio.symphmonitor.data.Employee;
import com.chipcerio.symphmonitor.data.source.SymphMonitorDataSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Jermaine on 05/11/2016.
 */
public class EmployeesSampPresenter implements EmployeesSampContract.SecondScreenSampPresenter {

    private EmployeesSampContract.SecondScreenSampView mView;
    private SymphMonitorDataSource mSymphMonitorDataSource;

    public EmployeesSampPresenter(EmployeesSampContract.SecondScreenSampView view,
                                  SymphMonitorDataSource symphMonitorDataSource) {
        this.mView = view;
        this.mSymphMonitorDataSource = symphMonitorDataSource;
    }

    @Override
    public void onIamPresentClick() {
        mSymphMonitorDataSource.setEmployeeAsPresent(new Employee(mView.getName()),
                new SymphMonitorDataSource.SetEmployeePresentCallback() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    mView.setError(R.string.error_has_occurred_text);
                }
            }
        });
    }
}
