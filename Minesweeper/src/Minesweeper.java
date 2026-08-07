import java.util.Scanner;

/**
 * 
 */
public class Minesweeper {
	static final int GRID_ROW = 6;
	static final int GRID_COLUMN = 12;
	static final int NB_BUMB = 9;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StateCase[][] grid = Grid.initGrid(GRID_ROW, GRID_COLUMN);
		int[][] bumbsCoord = Bumb.createNbBumbs(NB_BUMB, GRID_ROW, GRID_COLUMN);

		System.out.println("Bienvenu dans le jeu du Démineur.");
		Grid.displayGrid(grid, bumbsCoord);

		Scanner sc = new Scanner(System.in);
		int[] coordsUser;
		boolean continueGame = true;
		boolean loseGame = true;
		while (continueGame) {
			coordsUser = ControlUser.addCoordinate(sc, GRID_ROW, GRID_COLUMN);

			grid = Grid.changeState(grid, coordsUser, ControlUser.revealBox(sc));

			if (Bumb.isBumb(bumbsCoord, coordsUser[0], coordsUser[1])
					&& grid[coordsUser[0]][coordsUser[1]] == StateCase.SELECT) {
				continueGame = false;
			}

			Grid.displayGrid(grid, bumbsCoord);
		}

		if (loseGame) {
			System.out.println("Aaaaah !🤣 Vous avez perdu !! Voici la solution.");
			Grid.displaySolution(grid, bumbsCoord);
		} else {
			System.out.println("Bravo ! Vous avez gagné ! 🎉👏");
		}
	}

}
