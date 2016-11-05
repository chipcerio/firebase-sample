package com.chipcerio.symphmonitor.secondscreensamp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chipcerio.symphmonitor.R;
import com.chipcerio.symphmonitor.data.source.SymphMonitorRepository;
import com.chipcerio.symphmonitor.data.source.remote.SymphMonitorFirebaseDataSource;
import com.chipcerio.symphmonitor.welcomescreen.WelcomeActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jermaine on 05/11/2016.
 */
public class EmployeesSampActivity extends AppCompatActivity implements
        EmployeesSampContract.SecondScreenSampView {

    public static final String FIREBASE_EMPLOYEES = "Employees";

    private DatabaseReference mReference;
    private EmployeesSampPresenter mPresenter;
    private EmployeesAdapterSamp mAdapter;
    private String mName;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_samp);

        mPresenter = new EmployeesSampPresenter(this, SymphMonitorRepository.getInstance(
                SymphMonitorFirebaseDataSource.getInstance()
        ));
        mName = getIntent().getExtras().getString(WelcomeActivity.EXTRA_NAME);

        mReference = FirebaseDatabase.getInstance()
                .getReference().child(FIREBASE_EMPLOYEES);
        mAdapter = new EmployeesAdapterSamp(this, mReference);


        mRecyclerView = (RecyclerView) findViewById(R.id.employees_samp_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(mAdapter);
    }

    public void onIamPresentClick(View view) {
        mPresenter.onIamPresentClick();
    }


    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setError(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }
}
