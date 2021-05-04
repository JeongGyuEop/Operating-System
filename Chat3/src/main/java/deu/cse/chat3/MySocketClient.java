/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.chat3;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author tlatl
 */
public class MySocketClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket socket = null;
            // 소켓 서버에 접속
            socket = new Socket("172.30.1.30", 1234);
            System.out.println("서버에 접속 성공!"); // 접속 확인용

            // 서버에서 보낸 메세지 읽는 Thread
            ListeningThread t1 = new ListeningThread(socket);
            WritingThread t2 = new WritingThread(socket); // 서버로 메세지 보내는 Thread

            t1.start(); // ListeningThread Start
            t2.start(); // WritingThread Start

        } catch (IOException e) {
            e.printStackTrace(); // 예외처리
        }
    }

}
