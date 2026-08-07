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

		return new int[] { Integer.parseInt(selectRow) - 1, Integer.parseInt(selectColumn) - 1 };
	}

	private static boolean correctSelect(String indexSelect, int nbRowOrColumn) {
		int index;

		try {
			index = Integer.parseInt(indexSelect);
		} catch (Exception e) {
			System.err.println("Vouc n'avez pas saisie un nombre.");
			return false;
		}

		return 0 < index && index <= nbRowOrColumn;
	}

	public static boolean revealBox(Scanner sc) {
		int option = 0;
		String optionUser;
		boolean checkInput = false;

		do {
			System.out.println("Avec cette case, voulez-vous:\n" + "[1] Révélez la case.\n"
					+ "[2] Indiquez une potentielle BOMBE!");
			optionUser = sc.nextLine();
			try {
				option = Integer.parseInt(optionUser);
			} catch (Exception e) {
				System.err.println("Votre saisie n'est pas un entier");
			}

			if (option <= 0 || option > 2) {
				System.err.println("Votre saisie n'est pas un 1 ou 2.");
			} else {
				checkInput = true;
			}
		} while (!checkInput);

		return option == 1;
	}
}
