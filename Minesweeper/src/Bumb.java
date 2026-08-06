import java.util.Random;

/**
 * 
 */
public class Bumb {
	public int[][] createNbBumbs(int nbBumbs, int nbRows, int nbColumns) {
		int[][] listOfBumb = new int[nbBumbs][2];
		
		for (int nbBumbCreate = 0; nbBumbCreate < nbBumbs; nbBumbCreate++) {
			int[] bumbCoordinate = new int[2];
			do {
				Random random = new Random();
				bumbCoordinate[0] = random.nextInt(nbRows);
				bumbCoordinate[1] = random.nextInt(nbColumns);
			} while (isBumb(listOfBumb, bumbCoordinate[0], bumbCoordinate[1]));
		}
		
		return listOfBumb;
	}
}
