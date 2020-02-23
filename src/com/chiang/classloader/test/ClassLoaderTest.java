package com.chiang.classloader.test;

import java.net.URL;

/**
 * 根类加载器（bootstrap class loader）
 * 获得根类加载器所加载的核心类库,并会看到本机安装的Java环境变量指定的jdk中提供的核心jar包路径
 * @author 
 *
 */
public class ClassLoaderTest {
	
	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(URL url:urls) {
			System.out.println(url.toExternalForm());
		}
	}
}
