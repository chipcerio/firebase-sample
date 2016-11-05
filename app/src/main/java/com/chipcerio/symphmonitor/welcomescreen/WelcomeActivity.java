package com.chipcerio.symphmonitor.welcomescreen;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.chipcerio.symphmonitor.R;
import com.chipcerio.symphmonitor.secondScreen.SecondScreenActivity;
import com.chipcerio.symphmonitor.secondscreensamp.EmployeesSampActivity;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {

    public static final String EXTRA_NAME = "extra:name";

    private WelcomePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mPresenter = new WelcomePresenter(this, new WelcomeService());
    }

    public void onProceedClick(View view) {
        mPresenter.onProceedClick();
    }

    @Override
    public String getName() {
        return ((EditText) findViewById(R.id.welcome_editText)).getText().toString().trim();
    }

    @Override
    public void setNameError(int resId) {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(resId)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    @Override
    public void startNextActivity(String name) {
        Intent secondActivityIntent = new Intent(this, EmployeesSampActivity.class);
        secondActivityIntent.putExtra(EXTRA_NAME, name);
        startActivity(secondActivityIntent);
    }
}
