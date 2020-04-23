package com.jay.java.Pattern.FlyWeight;
/**
 * 测试享元模式
 * - 工厂：容器
 * - 外部状态：专门类进行处理，棋子对的位置
 * - 内部状态：享元类进行处理，棋子的颜色形状等,成员变量存储内部状态
 * @author jay
 *
 */
public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 =  ChessFlyWeightFactory.getChess("black");
		ChessFlyWeight chess2 =  ChessFlyWeightFactory.getChess("black");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("======");
		//外部状态，外面传递
		chess1.display(new Coordinate(10,10));
		chess2.display(new Coordinate(12,10));

	}
}
