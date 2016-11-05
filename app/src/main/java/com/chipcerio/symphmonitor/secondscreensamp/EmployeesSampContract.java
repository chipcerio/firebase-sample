package com.chipcerio.symphmonitor.secondscreensamp;
/**
 * Created by Jermaine on 05/11/2016.
 */
public class EmployeesSampContract {

    public interface SecondScreenSampView {
        String getName();

        void setError(int resId);
    }

    interface SecondScreenSampPresenter {
        void onIamPresentClick();
    }
}
