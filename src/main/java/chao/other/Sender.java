package chao.other;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

	private static DatagramSocket send;//套接字
	private static byte[] buff;//缓存区
	private static DatagramPacket packetReceived;//接收的包
	private static InetAddress inetAddress;
	
	public Sender() throws Exception {
		
		buff = new byte[1024];
		packetReceived = new DatagramPacket(buff, buff.length);
		inetAddress = InetAddress.getByName("localhost");
		send = new DatagramSocket(5000);
	}
	
	private static String send() throws IOException {
		Scanner scan = new Scanner(System.in);
		//要发送的信息
        String str = scan.next();
        byte[] buff = str.getBytes();
        //数据报文
        DatagramPacket datagramPacket = new DatagramPacket(buff,buff.length,inetAddress,4000);
        //发送
        send.send(datagramPacket);
        return str;

	}
	 private static String receive() throws IOException {
	        send.receive(packetReceived);
	        String str = new String(packetReceived.getData(),0,packetReceived.getLength());
	        return str;
	    }
	 
	    public static void main(String[] args) throws Exception {
	        Sender sender = new Sender();
	        new Thread(){
	            @Override
	            public void run() {
	                while (true){
	                    String msg = null;
	                    try {
	                        msg = send();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                    if(msg.equals("bye")){
	                        send.close();
	                        System.out.println("本次聊天结束");
	                        System.exit(0);
	 
	                    }
	                }
	            }
	        }.start(); //创建线程,调用start方法启动线程
	        new Thread(){
	            @Override
	            public void run() {
	                while (true) {
	                    String msg = null;
	                    try {
	                        msg = receive();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                    System.out.printf("%s:%s\n",packetReceived.getAddress().getHostAddress(),msg);
	                    if(msg.equals("bye")){
	                        send.close();
	                        System.out.println("本次聊天结束");
	                        System.exit(0);
	                    }
	                }
	            }
	        }.start();
	    }

}

