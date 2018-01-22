package com.example.messagec;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 接收消息
 */
public class ReceiverMessageService extends Service {

    TCPReceiver tcpReceiver;
    @Override
    public void onCreate() {
        super.onCreate();
        tcpReceiver = new TCPReceiver(10012);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
