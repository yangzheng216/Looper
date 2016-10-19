package com.parbat.looper;

import android.os.Handler;

/**
 * Created by 1 on 2016/10/19.
 */
public class MainLooper implements Runnable{
    public MainLooper(){
        Thread t = new Thread(this);
        t.start();
    }
    private Handler mHandler;
    public void LooperMain(){
        mHandler = new Handler();
    }

    @Override
    public void run() {
        int what = 0;
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(mHandler!=null){
                mHandler.post(new senderMessage(what));
                System.out.println("Handler post what ="+what);
                what+=1;
                if(what>5){
                    break;
                }
            }
        }
    }

    public class senderMessage implements Runnable{
        private int mWhat = -1;
        public senderMessage(int what){
            mWhat = what;
        }
        @Override
        public void run() {
            System.out.println("callback.run what ="+mWhat);
        }
    }
}
