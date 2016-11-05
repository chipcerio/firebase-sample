package com.chipcerio.symphmonitor.secondScreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chipcerio.symphmonitor.R;
import com.chipcerio.symphmonitor.data.Employee;

import java.util.List;

public class SecondScreenActivity extends AppCompatActivity implements NamesContract.View {

    private RecyclerView mRecycler;
    private FloatingActionButton mFab;
    private NamesPresenter mPresenter;
    private NamesAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen_activity);

        mPresenter = new NamesPresenter(this);

        mRecycler = (RecyclerView) findViewById(R.id.second_screen_activity_recycler_view);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(lm);

        mFab = (FloatingActionButton) findViewById(R.id.second_screen_activity_fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onFabClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onLoadNames();
    }

    @Override
    public void showNames(List<Employee> employees) {
        mAdapter = new NamesAdapter(employees);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mRecycler.setAdapter(mAdapter);
            }
        });
    }
}
