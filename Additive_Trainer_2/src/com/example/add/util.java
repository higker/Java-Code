package com.example.add;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 记录文件工具类
public class util {
	
	// 文件位置
	public static final String PATH = "/Users/ding/Desktop/exam.txt";
	
	// 文件写io流
	private static FileOutputStream FILE_OUT = null;
	
	// 往某个文件写入内容
	public static void writer(String path,String str) {
		try {
			FILE_OUT = new FileOutputStream(new File(PATH),true);
			FILE_OUT.write(str.getBytes());
			FILE_OUT.flush();
		} catch (FileNotFoundException e) {
			// 打开文件出错
			e.printStackTrace();
		} catch (IOException e) {
			// 写入文件异常
			e.printStackTrace();
		}finally {
			try {
				FILE_OUT.close();
			} catch (IOException e) {
				// 关闭文件异常
				e.printStackTrace();
			}
		}
	}
	
}
