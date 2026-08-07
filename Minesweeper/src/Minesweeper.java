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
		boolean loseGame = false;

		while (continueGame && !Grid.isEndGame(grid, bumbsCoord)) {
			coordsUser = ControlUser.addCoordinate(sc, GRID_ROW, GRID_COLUMN);

			if (grid[coordsUser[0]][coordsUser[1]] != StateCase.SELECT) {
				boolean reveal = ControlUser.revealBox(sc);
				grid = Grid.changeState(grid, coordsUser, reveal);

				if (Bumb.isBumb(bumbsCoord, coordsUser[0], coordsUser[1]) && reveal) {
					continueGame = false;
					loseGame = true;
				} else if (reveal) {
					grid = Grid.reveal0Bumb(grid, bumbsCoord, coordsUser);
				}
			} else {
				System.out.println("La case que vous avez choisie est déjà révélée.");
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
