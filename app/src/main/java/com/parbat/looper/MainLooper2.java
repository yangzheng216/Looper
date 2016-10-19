package com.parbat.looper;

import android.os.Handler;
import android.os.Message;

/**
 * Created by 1 on 2016/10/19.
 */
public class MainLooper2 implements Runnable{

    public MainLooper2(){
        Thread t = new Thread(this);
        t.start();
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
            if(mHandler != null){
                mHandler.sendMessage(mHandler.obtainMessage(what));
                System.out.println("mHandler sendMessage what ="+what);
                what+=1;
                if(what>5){
                    break;
                }
            }

        }
    }
    private Handler mHandler;
    public void LooperMain(){
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("handlerMessage what ="+msg.what);
                super.handleMessage(msg);
            }
        };
    }
}
