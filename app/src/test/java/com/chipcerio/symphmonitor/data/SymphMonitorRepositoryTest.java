package com.chipcerio.symphmonitor.data;

import com.chipcerio.symphmonitor.data.source.SymphMonitorDataSource;
import com.chipcerio.symphmonitor.data.source.SymphMonitorRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SymphMonitorRepositoryTest {
    private SymphMonitorRepository mSymphMonitorRepository;

    @Mock
    private SymphMonitorDataSource mFirebaseDataSource;

    @Mock
    private SymphMonitorDataSource.SetEmployeePresentCallback mSetEmployeePresentCallback;

    @Before
    public void setUp() throws Exception {
        mSymphMonitorRepository = SymphMonitorRepository.getInstance(mFirebaseDataSource);
    }

    @After
    public void tearDown() throws Exception {
        SymphMonitorRepository.destroyInstance();
    }

    @Test
    public void setThisEmployeeAsPresentToFirebaseDataSource() throws Exception {
        Employee employee = new Employee("Arth Limchiu");

        mSymphMonitorRepository.setEmployeeAsPresent(employee, mSetEmployeePresentCallback);
        verify(mFirebaseDataSource).setEmployeeAsPresent(eq(employee), any(SymphMonitorDataSource.SetEmployeePresentCallback.class));
    }
}