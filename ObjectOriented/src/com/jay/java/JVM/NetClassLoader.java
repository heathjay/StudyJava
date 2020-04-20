package com.jay.java.JVM;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetClassLoader extends ClassLoader{
	//com.jay.java.User -> www.jay.com/net
		private String rootUrl;
		
		public NetClassLoader(String rootUrl) {
			this.rootUrl = rootUrl;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			Class<?> c = findLoadedClass(name);
			//查询是否加载过这个类，如果已经加载则返回加载好的类，如果没有，则加载新的类
			if(c !=null) {
				return c;
			}else {
				ClassLoader parent = this.getParent();
				try {
					c = parent.loadClass(name);//委派给父类加载器
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//
				}
				if(c!=null) {
					return c;
				}else {
					byte[] classData = getClassData(name);
					if(classData == null) {
						throw new ClassNotFoundException();
					}else {
						c= this.defineClass(name, classData, 0,classData.length);
					}
				}
			}
			return c;
		}
		
		private byte[] getClassData(String classname) {
			String path = rootUrl + "/" + classname.replace('.', '/') + ".class";
			//可以使用IOUtils 可以使用它将流中的数据转成字节数组
			InputStream is =null;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				URL url = new URL(path);
				is = url.openStream();
				
				
				byte[] buffer = new byte[1024];
				int temp = 0;
				while(-1 != (temp=is.read(buffer))) {
					baos.write(buffer,0,temp);
				}
				return baos.toByteArray();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}finally {
				if(is !=null) {
					try {
						is.close();
						baos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
}
