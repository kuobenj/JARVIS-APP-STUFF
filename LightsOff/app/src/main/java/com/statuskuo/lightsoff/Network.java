package com.statuskuo.lightsoff;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Status on 7/11/2015.
 */
public class Network extends AsyncTask<Void, Void, Void> {
//    private Exception exception;

    @Override
    protected Void doInBackground(Void... params) {
        Socket mySock = null;
        String buffer = "Lights Off\r\n";
        OutputStream toServer = null;
        try {
            mySock = new Socket("192.168.0.5", 4040);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (mySock != null) {
                toServer = mySock.getOutputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (toServer != null)
                toServer.write(buffer.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (mySock != null) {
                mySock.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
