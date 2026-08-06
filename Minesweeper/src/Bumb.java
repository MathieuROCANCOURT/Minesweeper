import java.util.Random;

/**
 * 
 */
public class Bumb {
	private static Random random = new Random();
	
	public static int[][] createNbBumbs(int nbBumbs, int nbRows, int nbColumns) {
		int[][] listOfBumb = new int[nbBumbs][2];
		
		for (int nbBumbCreate = 0; nbBumbCreate < nbBumbs; nbBumbCreate++) {
			int[] bumbCoordinate = new int[2];
			do {
				bumbCoordinate[0] = random.nextInt(nbRows);
				bumbCoordinate[1] = random.nextInt(nbColumns);
			} while (isBumb(listOfBumb, bumbCoordinate[0], bumbCoordinate[1]));
		}
		
		return listOfBumb;
	}

	public static boolean isBumb(int[][] bombs, int row, int column) {
		for (int[] bomb: bombs) {
			if (bomb[0] == row && bomb[1] == column) {
				return true;
			}
		}
		return false;
	}

	public static int nbBumbAround(int[][] bombs, int row, int column) {
		int countBumb = 0;
		
		for (int indexRow = row - 1; indexRow <= row + 1; indexRow++) {
			for (int indexColumn = column - 1; indexColumn <= column + 1; indexColumn++) {
				if (Bumb.isBumb(bombs, indexRow, indexColumn)) {
					countBumb++;
				}
			}
		}
		return countBumb;
	}
}
