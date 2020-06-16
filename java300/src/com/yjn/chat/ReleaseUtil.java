package com.yjn.chat;

import java.io.Closeable;

/*
 * 工具类
 */
public class ReleaseUtil {
	//释放资源
	public static void close(Closeable...targets) {
		for(Closeable closeable:targets) {
			try {
				if(closeable!=null) {
					closeable.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
