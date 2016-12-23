package com.sebekerga.ultimatelinerider;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BluetoothManager {

    BluetoothDevice device;
    BluetoothAdapter bt_adapter;
    InputStream in_stream;
    OutputStream out_stream;
    BluetoothSocket socket;

    public void connect(BluetoothDevice device){

        //memorizing device(mb in future we need device's name)
        this.device = device;

        //creating socket 'n' connecting
        //initializing streams
        try {
            socket = device.createInsecureRfcommSocketToServiceRecord(device.getUuids()[0].getUuid());
            socket.connect();
            out_stream = socket.getOutputStream();
            in_stream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
