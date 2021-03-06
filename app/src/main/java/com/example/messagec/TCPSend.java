package com.example.messagec;


import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 发送
 */
public class TCPSend {
    /**
     * 发送数据的客户端Socket
     */
    private Socket socket;

    /**
     * @param ip   接收方的ip地址
     * @param port 接收方的端口号
     */
    public TCPSend(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            out = socket.getOutputStream();
            Log.i("---", "isBound" + socket.isBound() + " isConnected" + socket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    OutputStream out = null;
    /**
     * 发送数据
     */
    public void sendMessage(String msg) {
        if (socket == null) {
            return;
        }
        Log.i("---", "isBound" + socket.isBound() + " isConnected" + socket.isConnected());
        try {
            out.write(msg.getBytes());
            out.flush();
            Log.i("---", msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void close() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isInputShutdown()) { //判断输入流是否为打开状态
            try {
                socket.shutdownInput();  //关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isOutputShutdown()) {  //判断输出流是否为打开状态
            try {
                socket.shutdownOutput(); //关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isConnected()) {  //判断是否为连接状态
            try {
                socket.close();  //关闭socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
