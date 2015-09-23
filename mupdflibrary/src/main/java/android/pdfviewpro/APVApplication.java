package android.pdfviewpro;

import android.app.Application;
import android.util.Log;

import pdf.CrashHandler;
//import android.lib.pdf.PDF;

public class APVApplication extends Application {
    
    private final static String TAG = "android.pdfviewpro";

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    public boolean hasChanged=false;
    private static APVApplication mInstance=null;

    int threadCount=2;
    int threadPriority=3;
    
    public static APVApplication getInstance(){
    	return mInstance;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount=threadCount;
    }

    public int getThreadPriority() {
        return threadPriority;
    }

    public void setThreadPriority(int threadPriority) {
        this.threadPriority=threadPriority;
    }

    public void onCreate() {
        super.onCreate();
        //PDF.setApplicationContext(this); // PDF class needs application context to load assets
        mInstance=this;
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }
    
    /**
     * Called by system when low on memory.
     * Currently only logs.
     */
    public void onLowMemory() {
        super.onLowMemory();
        Log.w(TAG, "onLowMemory"); // TODO: free some memory (caches) in native code
    }

}