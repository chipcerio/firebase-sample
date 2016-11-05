package com.chipcerio.symphmonitor.names;

import com.chipcerio.symphmonitor.data.Employee;
import com.chipcerio.symphmonitor.secondScreen.NamesContract;
import com.chipcerio.symphmonitor.secondScreen.NamesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NamesTest {

    private NamesPresenter mPresenter;

    private List<Employee> mMockList;

    @Mock
    private NamesContract.View mView;

    @Before
    public void setUp() throws Exception {
        mPresenter = new NamesPresenter(mView);
    }

    @Test
    public void displayNames() throws Exception {
        mMockList = mock(List.class);

        when(mMockList.get(0)).thenReturn(new Employee("chip"));
        when(mMockList.get(1)).thenReturn(new Employee("arth"));
        when(mMockList.get(2)).thenReturn(new Employee("jermaine"));
        when(mMockList.get(3)).thenReturn(new Employee("kenneth"));

        mPresenter.onLoadNames();

        // verify(mView).showNames();
    }
}
