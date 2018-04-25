package com.yeho.movies.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.yeho.movies.data.Constants;

/**
 * Created by yeho on 24/04/2018.
 */

public class Utils {

  private static final String TAG = "YEHO";

  public static void showDialogOK(Context context, String title, String message) {
    AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(context);

    alertDialog2.setTitle(title);
    alertDialog2.setMessage(message);
    alertDialog2.setPositiveButton(Constants.OK, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {
        //Do nothing
      }
    });
    alertDialog2.show();
  }

  public static boolean isNetworkAvailable(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
