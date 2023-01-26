package com.main;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz ");
		System.out.println("Tarlanın Boyutlarını Giriniz !");
		System.out.println("Satır :");
		int row = scan.nextInt();
		System.out.println("Sutun :");
		int col = scan.nextInt();
		MineSweeper a = new MineSweeper(row,col);
		a.Baslat();
		scan.close();
	}

}
