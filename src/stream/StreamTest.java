package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamTest {

	public static void stream1() throws IOException {
		// 节点流FileOutputStream直接以A.txt作为数据源操作
		FileOutputStream fileOutputStream = new FileOutputStream(
				"D:/src/java_workspace/ExerciseBook/resources/1A.txt");
		// 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				fileOutputStream);
		// 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
		DataOutputStream out = new DataOutputStream(bufferedOutputStream);
		out.writeInt(3);
		out.writeBoolean(true);
		out.flush();
		out.close();
		// 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(
						"D:/src/java_workspace/ExerciseBook/resources/1A.txt")));
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		in.close();
	}

	public static void writerNreader() throws IOException {
		FileOutputStream fos = new FileOutputStream(
				"D:/src/java_workspace/ExerciseBook/resources/1B.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("www.sohu.com");
		bw.close();
		FileInputStream fis = new FileInputStream(
				"D:/src/java_workspace/ExerciseBook/resources/1B.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		br.close();
	}

	public static void main(String[] args) throws IOException {
		stream1();
		writerNreader();
	}
}
