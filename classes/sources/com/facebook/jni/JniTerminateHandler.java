package com.facebook.jni;

import java.lang.Thread;

public class JniTerminateHandler {
    public static void handleTerminate(Throwable th) throws Throwable {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}