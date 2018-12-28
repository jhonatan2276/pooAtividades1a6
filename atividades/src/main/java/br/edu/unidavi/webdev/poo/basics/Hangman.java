package br.edu.unidavi.webdev.poo.basics;

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		String pass = "Ghost";
		char[] placeholder = new char[pass.length()];
		for (int i = 0; i < pass.length(); i++)
			placeholder[i] = '*';
		boolean canPlay = true;
		int wrongs = 0;
		int limit = 6;
		boolean gotcha = false;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.printf("Your attempt: %d/%d", wrongs, limit);
			String attempt = scanner.nextLine();
			boolean hit = false;
			gotcha = true;
			String placeholderAsString = "";
			for (int i = 0; i < pass.length(); i++) {
				if (pass.charAt(i) == attempt.charAt(0)) {
					placeholder[i] = attempt.charAt(0);
					hit = true;
				}
				gotcha = gotcha & (pass.charAt(i) == placeholder[i]);
				placeholderAsString += placeholder[i];
			}
			if (!hit)
				wrongs++;
			canPlay = wrongs < limit && !gotcha;
			System.out.println(placeholderAsString);
		} while (canPlay);
		scanner.close();
		System.out.println("You ".concat(gotcha ? " win" : " lose"));
	}
}
