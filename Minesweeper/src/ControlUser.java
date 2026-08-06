import java.util.Scanner;

public class ControlUser {
	public static int[] addCoordinate(Scanner sc, int nbRow, int nbColumn) {
		System.out.println("Quelle case voulez-vous visez ?");
		System.out.print("Veuillez saisir le numéro de ligne: ");
		String selectRow = sc.nextLine();

		while (!correctSelect(selectRow, nbRow)) {
			System.err.println("Saisie incorrect");
			System.out.print("Veuillez saisir le numéro de ligne: ");
			selectRow = sc.nextLine();
		}

		System.out.print("Veuillez saisir le numéro de colonne: ");
		String selectColumn = sc.nextLine();

		while (!correctSelect(selectColumn, nbColumn)) {
			System.err.println("Saisie incorrect");
			System.out.print("Veuillez saisir le numéro de colonne: ");
			selectColumn = sc.nextLine();
		}

		return new int[] { Integer.parseInt(selectRow), Integer.parseInt(selectColumn) };
	}

	private static boolean correctSelect(String indexSelect, int nbRowOrColumn) {
		int index;
		
		try {
			index = Integer.parseInt(indexSelect);
		} catch (Exception e) {
			System.err.println("Vouc n'avez pas saisie un nombre.");
			return false;
		}
		
		return 0 <= index && index < nbRowOrColumn;
	}
}
