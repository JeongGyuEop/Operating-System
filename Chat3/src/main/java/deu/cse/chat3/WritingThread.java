/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.chat3;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author tlatl
 */
public class WritingThread extends Thread {

    Socket socket = null;
    Scanner scanner = new Scanner(System.in); // 채팅용 Scanner

    public WritingThread(Socket socket) { // 생성자
        // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
        this.socket = socket;
    }

    public void run() {
        try {
            // OutputStream - 클라이언트에서 Server로 메세지 발송 
            // socket의 OutputStream 정보를 OutputStream out에 넣은 뒤
            OutputStream out = socket.getOutputStream();
            // PrintWriter에 위 OutputStream을 담아 사용
            PrintWriter writer = new PrintWriter(out, true);

            while (true) { // 무한반복
                if(scanner.nextLine().equals("exit")){
                    System.out.println(writer + "가 채팅을 종료하였습니다.");
                    writer.println(writer + "가 채팅을 종료하였습니다.");
                    break;
                }else{
                    writer.println(scanner.nextLine()); // 입력한 메세지 발송
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // 예외처리
        }

    }
}
