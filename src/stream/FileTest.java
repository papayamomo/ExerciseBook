package stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		String path = "D:/src/java_workspace/ExerciseBook/resources/1C.txt";
		File file = new File(path);
		if (!file.exists()) {// 判断文件是否存在
			try {
				file.createNewFile(); // 创建文件
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter fileWriter = new FileWriter(path, true);
			fileWriter.write("Hello World");
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* 获取文件名 */
		String name = file.getName();
		/* 获取文件路径 */
		String path_ = file.getPath();
		/* 获取绝对路径名 */
		String absPath = file.getAbsolutePath();
		/* 获取父亲文件路径 */
		String parent = file.getParent();
		/* 文件大小 */
		long size = file.length();
		/* 最后一次修改时间 */
		long time = file.lastModified();
		System.out.println("文件名:" + name);
		System.out.println("文件路径:" + path_);
		System.out.println("文件的绝对路径:" + absPath);
		System.out.println("文件的父文件路径:" + parent);
		System.out.println("文件的大小:" + size);
		System.out.println("文件最后一次修改时间:" + time);
		// file.delete(); //删除文件
	}
}
