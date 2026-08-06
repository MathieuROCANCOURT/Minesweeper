/**
 * 
 */
public class Minesweeper {
	static final int GRID_ROW = 6;
	static final int GRID_COLUMN = 12;

	/**
	 * @param args
	 */
	public static void main(String[] args) {;
		StateCase[][] grid = Grid.initGrid(GRID_ROW, GRID_COLUMN);
		int[][] bumbsCoord = Bumb.createNbBumbs(9, GRID_ROW, GRID_COLUMN);
		
		System.out.println("Bienvenu dans le jeu du Démineur");
		Grid.displayGrid(grid, bumbsCoord);
	}

}
