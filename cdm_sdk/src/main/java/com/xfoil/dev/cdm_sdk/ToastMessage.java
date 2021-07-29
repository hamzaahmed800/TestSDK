package com.xfoil.dev.cdm_sdk;

import android.content.Context;
import android.widget.Toast;

public class ToastMessage {


    public static void printMessageForShort(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public static void printMessageForLong(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}
