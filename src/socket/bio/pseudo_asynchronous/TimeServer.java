package socket.bio.pseudo_asynchronous;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import socket.bio.TimeServerHandler;

public class TimeServer {

	// 线程池处理客户端请求
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8080);
			System.out.println("The time server is start in port :8080");
			Socket socket = null;
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
					50, 1000);
			while (true) {
				socket = server.accept();
				singleExecutor.execute(new TimeServerHandler(socket));
			}
		} finally {
			if (server != null) {
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
	}
}
