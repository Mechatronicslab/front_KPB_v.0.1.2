package com.example.kpbv20.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import com.example.kpbv20.R;

public class LoadingDialog {

    private static AlertDialog dialog;
    private Activity activity;

    public LoadingDialog(Activity myActivity){
        activity = myActivity;
    }

    public static void startLoadingDialog(Activity activity){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog_signin, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    public static void dismissDialog(){
        dialog.dismiss();
    }
}
