package com.jay.java.Pattern.Component;
/**
 * 组合模式对所有节点都进行同样的操作
 * 天然递归,
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5,f6;
		Folder f1;
		f1 = new Folder("myFolder");
		f2 = new ImageFile("badboy");
		f3 = new TextFile("jj");
		Folder f11 = new Folder("xx");
		f4 = new VideoFile("xhsufhu.avi");
		f5 = new VideoFile("wss.avi");
		
		f11.add(f4);
		f11.add(f5);
		
		f1.add(f2);
		f1.add(f3);
		f1.add(f11);
		
		f1.killVirus();
	}
}
