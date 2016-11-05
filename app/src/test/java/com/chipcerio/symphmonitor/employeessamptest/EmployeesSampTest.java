package com.chipcerio.symphmonitor.employeessamptest;

import com.chipcerio.symphmonitor.data.source.SymphMonitorRepository;
import com.chipcerio.symphmonitor.data.source.remote.SymphMonitorFirebaseDataSource;
import com.chipcerio.symphmonitor.secondscreensamp.EmployeesSampContract;
import com.chipcerio.symphmonitor.secondscreensamp.EmployeesSampPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by Jermaine on 05/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeesSampTest {

    EmployeesSampPresenter presenter;
    @Mock
    EmployeesSampContract.SecondScreenSampView view;
    @Mock
    SymphMonitorRepository monitorRepository;

    @Before
    public void setUp() throws Exception {
        presenter = new EmployeesSampPresenter(view, monitorRepository);
    }

    @Test
    public void shouldShowErrorWhenIamPresentHasError() throws Exception {

    }
}
