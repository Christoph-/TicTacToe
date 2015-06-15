public class Board{
	
	String[][] boardGame;
	boolean winner;
	
	public Board(){
		boardGame = new String[3][3];
		winner = false;
	}
	
	public void setMark(String mark, int x, int y) throws InvalidPositionException{
		if(boardGame[x][y] == null){
			boardGame[x][y] = mark;
		} 
		else {
			throw new InvalidPositionException();
		}
	}
	
	public boolean hasWinner(){
		return checkRows() || checkColumns() || checkDiagonals();
	}
	
	private boolean checkRows(){
		for(int i = 0; i < boardGame.length; i++){
				if(boardGame[i][0].equalsIgnoreCase(boardGame[i][1]) && boardGame[i][0].equalsIgnoreCase(boardGame[i][2])){
					winner = true;
			}
		}
		return winner;
	}
	
	private boolean checkColumns(){
		for(int i = 0; i < boardGame.length; i++){
				if(boardGame[0][1].equalsIgnoreCase(boardGame[1][i]) && boardGame[0][1].equalsIgnoreCase(boardGame[2][i])){
					winner = true;
			}
		}
		return winner;
	}
	
	private boolean checkDiagonals(){
		if(boardGame[0][0].equalsIgnoreCase(boardGame[1][1]) && boardGame[0][0].equalsIgnoreCase(boardGame[2][2])){
			winner = true;
		}
		else if(boardGame[0][2].equalsIgnoreCase(boardGame[1][1]) && boardGame[0][2].equalsIgnoreCase(boardGame[2][0])){
			winner = true;
		}
		return winner;
	}
}