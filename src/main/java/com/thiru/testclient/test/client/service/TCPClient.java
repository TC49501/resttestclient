package com.thiru.testclient.test.client.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thiru on 6/25/17.
 */
public class TCPClient {
    private static final String DIAL_IDNT = "DIAL999UT02445@U22ASPR52021B  P         IDNT                    999UT02445@U2 I02  666005767SHERRI                        BBBRR                                                                               MX                                                  01AD5111        VYOUIYC                   AVPASCAGOULA          MS39581                                                         \r\n";
    static String host = "ipgate-uat.us.equifax.com"; //--IPG  ipgate-uat.us.equifax.com   172.21.88.92
    static Integer clientPort = 6089;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(final String[] args) throws IOException {
        sendAndreceiveData(DIAL_IDNT);
    }

    private static String readInputStream(BufferedInputStream bin) throws IOException {
        StringBuffer buf = new StringBuffer();
        int b;
        while ((b = bin.read()) >= 0) {
            buf.append((char) b);
            if (buf.indexOf("&&") > 0) break;
        }
        return buf.toString();
    }

    public static String sendAndreceiveData(String data) throws IOException {
        System.out.println("start time:" + sdf.format(new Date()));
        Socket socket = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        String response = "";
        try {
            String request = String.format("%06d", DIAL_IDNT.length()) + data;
            System.out.println("Data request:" + request);

            socket = new Socket(host, clientPort);
            socket.setSoTimeout(10000); //10sec

            bis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(socket.getOutputStream());

            bos.write(request.getBytes(), 0, request.length());
            bos.flush();

            response = readInputStream(bis);
            System.out.println("Data response:" + response);
            System.out.println("end time:" + sdf.format(new Date()));
        } catch (Exception e) {
            System.err.println("Error in  TCPClient");
            e.printStackTrace();
        }
        return response;
    }
}