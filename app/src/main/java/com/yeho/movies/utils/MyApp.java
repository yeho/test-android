package com.yeho.movies.utils;

import android.app.Application;

/**
 * Created by Yeho on 24/04/2018
 *
 */
public class MyApp  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

      // Setup handler for uncaught exceptions.
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                handleUncaughtException(thread, e);
            }
        });

    }

  private void handleUncaughtException(Thread thread, Throwable e) {
      System.exit(1); // kill off the crashed app
    }
}
