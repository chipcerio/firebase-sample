package com.chipcerio.symphmonitor.secondScreen;

import com.chipcerio.symphmonitor.data.Employee;

import java.util.List;

public interface NamesContract {

    interface View {
        void showNames(List<Employee> employees);
    }
}
