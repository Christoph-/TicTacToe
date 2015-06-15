import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	
	Board board;
	
	@Before
	public void initialize(){
		board = new Board();
	}

	@Test // leeres Feld und keine Gewinner
	public void test1() {
		assertFalse(board.hasWinner());
	}
	
	@Test // gueltige Markierung setzen - keine Gewinner
	public void test2() throws InvalidPositionException{
		board.setMark("x", 0, 0);
		assertFalse(board.hasWinner());
	}
	
	@Test // gueltige Markierungen setzen - mit Gewinner
	public void test3() throws InvalidPositionException{
		board.setMark("o", 0, 2);
		board.setMark("o", 1, 1);
		board.setMark("o", 2, 0);
		assertTrue(board.hasWinner());
	}
	
	@Test (expected = InvalidPositionException.class) // ungueltige Markierungen setzen
	public void test4() throws InvalidPositionException{
		board.setMark("x", -1, 9);
	}
}
