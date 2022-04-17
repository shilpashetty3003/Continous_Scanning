package com.example.myapplication.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SampleWork extends Worker {
    int a=0;
    public SampleWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("TAG", "doWork: "+a);

       // Data output= new Data.Builder().putString("workresult","Finishedd").build();

        return Result.success();
    }
}
