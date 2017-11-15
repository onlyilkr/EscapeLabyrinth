import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class Maze {
	static char Board[][] = new char[8][8];
	// Locations of black stamps
	static List<Stamp> BLACK_STAMPS = new ArrayList<Stamp>();
	static int FIRST_SHORTEST_WAY;

	// Constructor
	public Maze() {
		// Generate random black stamps
		int randCol, randRow;
		Random rand = new Random();
		int siyahSayi = 3 + rand.nextInt(6);

		Stamp temp = new Stamp();
		for (int i = 0; i < siyahSayi - 1; i++) {
			do {
				randCol = rand.nextInt(8);
				randRow = rand.nextInt(8);
				temp.setX(randCol);
				temp.setY(randRow);
			} while (BLACK_STAMPS.contains(temp) || (temp.getX() == 0 && temp.getY() == 0)
					|| (temp.getX() == 7 && temp.getY() == 7));
			BLACK_STAMPS.add(new Stamp(randCol, randRow));

		}
		int randR = (1 + rand.nextInt(6));
		BLACK_STAMPS.add(new Stamp(randR, randR));

		// Chessboard fill with "dot"
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				Board[i][j] = '.';
			}
		}
		
		// Chessboard fill with generated black stamps
		for (Stamp array : BLACK_STAMPS) {
			Board[array.getX()][array.getY()] = 'B';

		}
		Board[0][0] = 'W';

	}

	// Show chessboard on console
	public void showBoard() {
		Character row = 'A';
		System.out.print("\n ");
		for (int i = 0; i < 8; ++i) {
			System.out.print(" " + (row++));
		}
		System.out.println();
		for (int i = 0; i < 8; ++i) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < 8; ++j) {
				System.out.print(Board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Possible movement directions of the stamps
	static int[] col = { 1, 0, 1, 1, 0, -1, -1, -1 };
	static int[] row = { 1, 1, 0, -1, -1, -1, 0, 1 };

	// Check 1: Going out of the chessboard
	public static boolean valid(int x, int y) {
		if (x < 0 || y < 0 || x >= 8 || y >= 8) {
			return false;
		}
		return true;

	}

	// Check 2: Check that there is no black stamp at the given place
	public static boolean filledCell(int x, int y) {
		for (Stamp array : BLACK_STAMPS) {
			if (array.getX() == x && array.getY() == y) {
				return false;
			}
		}
		return true;
	}

	// Run Breadth-first search algorithm
	public static int BFS(Node src, Node dest) {
		// Visited locations
		Map<Node, Boolean> visited = new HashMap<Node, Boolean>();
		// Followed path
		Queue<Node> q = new LinkedList<Node>(); 
		
		q.add(src);
		while (!q.isEmpty()) {

			Node stamp = q.peek();
			q.remove();

			int x = stamp.getX();
			int y = stamp.getY();
			int dist = stamp.getDist();

			if (x == dest.getX() && y == dest.getY()) {
				return dist;
			} else if (!visited.containsKey(stamp)) {
				visited.put(stamp, true);
				for (int i = 0; i < 8; ++i) {
					int x1 = x + col[i];
					int y1 = y + row[i];
					if (valid(x1, y1) && filledCell(x1, y1)) {
						q.add(new Node(x1, y1, dist + 1));
					}
				}
			}
		}
		return 1;
	}

	// The way the white stamp went
	static void printPath(Node curr, Node dest, int curr_dist, int dist, ArrayList<Node> Path) {
		if (FIRST_SHORTEST_WAY != 1) {
			if (curr_dist > dist)
				return;
			if (curr_dist == dist && (curr.getX() == dest.getX() && curr.getY() == dest.getY())) {
				System.out.println("Path for White Stamp:");
				for (Node array : Path) {
					// Print going way
					System.out.print("("+(array.getX()+1)+","+(array.getY()+1)+")"+" ");
					Board[array.getX()][array.getY()] = '+';
				}
				FIRST_SHORTEST_WAY = 1;
				return;
			}
			int x = curr.getX();
			int y = curr.getY();
			Node whiteStamp = new Node(x, y);

			for (int i = 0; i < 8; ++i) {
				int x1 = x + col[i];
				int y1 = y + row[i];

				if (valid(x1, y1) && filledCell(x1, y1)) {
					whiteStamp.setX(x1);
					whiteStamp.setY(y1);
					Path.add(whiteStamp);
					printPath(whiteStamp, dest, curr_dist + 1, dist, Path);
				}
				Path.remove(whiteStamp);
			}

		}
		
	}

	public void solve() {
		Node src = new Node(0, 0);
		Node dest = new Node(7, 7);
		// According to the value from BFS - dist - control is provided.
		printPath(src, dest, 0, BFS(src, dest), new ArrayList<Node>());
	}

}
