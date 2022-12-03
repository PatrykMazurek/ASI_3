package up.server;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient implements Runnable{

    private DatagramSocket socket;

    @Override
    public void run() {
        for (int i = 0; i<15; i++){
            getMessage(""+i);
        }
    }

    public UDPClient(){
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String s){
        byte[] buffIn = new byte[512];
        try {
            DatagramPacket packetIn = new DatagramPacket(buffIn, buffIn.length);
            DatagramPacket packetOut = new DatagramPacket(s.getBytes(), s.length(),
                    InetAddress.getLocalHost(), 5501);
            socket.send(packetOut);

            socket.receive(packetIn);

            String message = new String(packetIn.getData(), 0, packetIn.getLength(),
                    StandardCharsets.UTF_8);

            System.out.println(message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){ socket.close();}


}
