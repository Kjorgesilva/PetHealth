package br.com.petHealth.utils;

import java.util.Random;

public class SenhaRandom {
	
	public static String getSenhaRandom() {
		char[] chart = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		char[] senha = new char[6];
		int chartLenght = chart.length;
		Random rdm = new Random();
		for (int x = 0; x < 6; x++)
			senha[x] = chart[rdm.nextInt(chartLenght)];
		return new String(senha);
	}
}
