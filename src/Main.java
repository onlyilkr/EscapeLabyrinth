/*
 * @author Ýlker GÜLDALI
 * 
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("<-- Chessboard first situation--> B: Black stamp W: White stamp +: Path followed");
		
		Maze test = new Maze();
		test.showBoard();
		
		System.out.println("<--Chessboard final situation -->");
		test.solve();
		test.showBoard();
		
		
	}

}
