package com.example.myapplication;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class MyService extends JobService {
    int num=0;
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("TAG", "onStartJob: "+num);
        Toast.makeText(this, "ggjkgjgjkhjkhj", Toast.LENGTH_SHORT).show();
        num++;

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
