
public class Cell {
	int c, climb;
	boolean isLadder=true, isSnake=true;
	public Cell(int c) {
		this.c = c;
	}
	public int getCell() {
		return c;
	}
	
	public boolean isLadder() {
	    return isLadder;
	}

	public void setIsLadder(boolean isLadder) {
	    this.isLadder = isLadder;
	}
	
	public boolean isSnake() {
	    return isLadder;
	}

	public void setIsSnake(boolean isSnake) {
	    this.isSnake = isSnake;
	}
	
	
	
	public void setClimb(int climb) {
		this.climb=climb;
	}
	public int getClimb() {
		return climb;
	}
}
