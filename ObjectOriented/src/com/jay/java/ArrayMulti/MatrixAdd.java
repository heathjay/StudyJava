package com.jay.java.ArrayMulti;
/**
 * 
 * @author jay
 * 矩阵相加
 *
 */
public class MatrixAdd {
	public static void print(int[][] c) {
		for(int i = 0; i < c.length;i++) {
			for(int j = 0; j < c.length; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
	}
	/**
	 * 矩阵加法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[][] add(int[][] a, int[][] b){
		int[][] c = new int[a.length][b.length];
		for(int i = 0; i < c.length;i++) {
			for(int j = 0; j < c.length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	public static void main(String[] args) {
		int[][] a = {
				{1,3},
				{2,4}
		};
		
		int[][] b = {
				{3,4},
				{5,6}
		};
		
		int[][] c = add(a,b);

		
		print(c);
	}
}
