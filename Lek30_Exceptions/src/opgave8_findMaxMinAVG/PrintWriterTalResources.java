package opgave8_findMaxMinAVG;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PrintWriterTalResources {

	public static void main(String[] args) {

		//String fileName = "tal.txt";
		//	String fileName = "C:/MAD/Ud/tal7.txt";
		//	String fileName = "C:\\MAD\\Workspace\\IntelliJJava\\PRO1_23T\\tal.txt";
		String filePath = "C:\\Users\\Sean\\IdeaProjects\\Programmering1\\Lek30_Exceptions\\src\\opgave8_FindMaxMinAVG\\2500tal.txt";
		try(Scanner scan = new Scanner(System.in);
			PrintWriter printWriter = new PrintWriter(filePath)) {

			// indlaes antal tal i filen
			System.out.print("Antal tal der skal skrives i filen: ");
			int antal = scan.nextInt();

			// skab tilfældige tal generator Random
			Random rnd = new Random();

			// generer og skriv de tilfældige tal
			for (int n = 1; n <= antal; n++) {
				int tal = rnd.nextInt(10000);
				printWriter.println(tal);
			}

			System.out.println("Filen er lavet");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
