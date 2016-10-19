package com.parbat.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by 1 on 2016/10/19.
 */
public class ThreadLooper implements Runnable,Handler.Callback{

    public ThreadLooper(){
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
                System.out.println("sendMessage what ="+what);
                what +=1;
                if(what >5){
                    mHandler.getLooper().quit();
                    break;
                }
            }
        }
    }

    public void runOtherLoop(){
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                LooperRun();
            }
        });
        th.start();
    }
    Handler mHandler = null;
    public void LooperRun(){
        Looper.prepare();
        mHandler = new Handler(this);
        Looper.loop();
        System.out.println("***************loop end****************");
    }

    @Override
    public boolean handleMessage(Message message) {
        System.out.println("handlerMessage what ="+message.what);
        return false;
    }
}
