package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UDPServer {

    private DatagramSocket socket;
    private DatagramPacket packet;

    public UDPServer(){
        try {
            socket = new DatagramSocket(5501);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void getConncetion(){
        byte[] buff = new byte[32];
        while (true){
            try {
                packet = new DatagramPacket(buff, buff.length);
                socket.receive(packet);
                String m = new String(packet.getData(), 0 ,
                        packet.getLength(),
                        StandardCharsets.UTF_8);

                System.out.println("wiadomość z " + packet.getAddress()
                + " o treści " + m);

                packet.setData("Odpoweidz zwrotna ".getBytes(StandardCharsets.UTF_8));
                if (m.equals("end"))
                {
                    System.out.println("Koniec pracy serwera");
                    socket.send(packet);
                    break;
                }
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

}
