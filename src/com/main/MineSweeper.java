package com.main;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	
	int satirNumarasi,sutunNumarasi,boy;
	int Arttir;
	String harita[][];
	String tahta[][];
	boolean game = true;
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	public MineSweeper(int satirNumarasi, int sutunNumarasi) {
		this.satirNumarasi = satirNumarasi;
		this.sutunNumarasi = sutunNumarasi;
		this.boy = satirNumarasi*sutunNumarasi;
		this.harita = new String[satirNumarasi][sutunNumarasi];
		this.tahta = new String[satirNumarasi][sutunNumarasi];
		
	}
	// Oyunu Başlatır
	public void Baslat() {
		int satir,sutun,succes=0;
		MayinlariHazirla();		
		dedektor();
		//print(harita);
		System.out.println("Oyun Başladı !");
		while(game) {
			print(tahta);		
			System.out.print("Satir : ");
			satir= input.nextInt();
			System.out.print("Sutun : ");
			sutun = input.nextInt();
			if(satir < 0 || satir >= tahta.length || sutun < 0 || sutun >= tahta[0].length) {
				System.out.println("Girdiginiz degerleri kontrol edin !");
			}else {
				if(harita[satir][sutun] != "*") {	
					BolgeyiKaz(satir,sutun);
					succes++;
					if(succes == (boy-(boy/4))) {
						System.out.println("Tebrikler Oyunu Kazandınız !");
						print(harita);
						System.out.println("Tekrar Oynamak istermisin ?\n1-Evet,2-Hayır :");
						int secim = input.nextInt();
						if(secim == 1) {
							Baslat();
						}else {
							game = false;
						}
					}
				}else {
					System.out.println("Oyunu Kaybettin !");
					print(harita);
					System.out.println("Tekrar Oynamak istermisin ?\n(1-Evet,2-Hayır)");
					int secim = input.nextInt();
					if(secim == 1) {
						Baslat();
					}else {
						game = false;
					}
				}
			}
		}
	}
	// Girilen degerin etrafında kaç adet mayın varsa onu yazar
	private void MayinSayYaz(int r,int c) {	
		for (int i = r -1; i <= r +1; i++) {			
			for (int j = c -1; j <= c +1; j++) {				
				try {	
					if(harita[i][j] != harita[r][c]) {
					 Arttir++;
					 int b =Arttir+Integer.parseInt(harita[i][j]);
					 Arttir=0;
					 harita[i][j]=Integer.toString(b);					 
					}
					 
				} catch (Exception e) {
				}			
			}
		}	
	}	
	// Haritaya mayınları ekler
	public void MayinlariHazirla() {
		int randRow,randCol,count=0;
   		while (count != (boy/4)) {
   			randRow = rand.nextInt(satirNumarasi);
   			randCol = rand.nextInt(sutunNumarasi);
   				if (harita[randRow][randCol] !="*") {
   					harita[randRow][randCol] = "*";
   					count++;    			 
   				}
   		}
   		for (int i = 0; i < harita.length; i++) {
			for (int j = 0; j < harita[0].length; j++) {
				tahta[i][j] = "-";
				if(harita[i][j] != "*") {
					harita[i][j] = "0";	
				}
			}		
		}
    }
	// Mayınların yerini bulur
	public void dedektor() {
		for (int row = 0; row < harita.length; row++) {
			for (int col = 0; col < harita[0].length; col++) {
				if(harita[row][col]=="*") {
					MayinSayYaz(row, col);
				}
			}
		}
	}
	// Tabloları yazar
	public void print(String[][] dizi) {
		
		for (int i = 0; i < dizi.length; i++) {
			for (int j = 0; j < dizi[0].length; j++) {				
					System.out.print(" ");
					System.out.print(dizi[i][j]+ " ");	
			}
			System.out.println();
		}
	}
	// Girilen kordinatları kazar
	public void BolgeyiKaz(int r,int c) {
			tahta[r][c]=harita[r][c];	
	}
}
