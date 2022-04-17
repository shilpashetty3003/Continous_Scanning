package com.example.myapplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private Timer myTimer;
    int number = 0;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        scheduleJob();
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor flag = preferences.edit();
        if (preferences.getBoolean("checked", true)) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);

        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    flag.putBoolean("checked", true);
                    flag.apply();
                } else {
                    flag.putBoolean("checked", false);
                    flag.apply();
                }
            }
        });


       /* myTimer=new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d("TAG", "run: "+number);
                number++;
            }
        },1,1000*6);*/
    }

    private void scheduleJob() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(MainActivity.this, MyService.class);
        JobInfo.Builder jobInfo = new JobInfo.Builder(101, componentName).setPeriodic(2000);
        jobScheduler.schedule(jobInfo.build());
    }




}