package com.chipcerio.symphmonitor.secondScreen;

import com.chipcerio.symphmonitor.data.Employee;
import com.chipcerio.symphmonitor.util.Cheese;

import java.util.ArrayList;
import java.util.List;

public class NamesPresenter {

    private NamesContract.View mView;

    public NamesPresenter(NamesContract.View view) {
        mView = view;
    }

    public void onLoadNames() {
        // show indicator

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    List<Employee> employees = new ArrayList<>(Cheese.LIST.length);
                    for (String s : Cheese.LIST) {
                        Employee employee = new Employee(s);
                        employees.add(employee);
                    }
                    mView.showNames(employees);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onFabClick() {
    }
}
