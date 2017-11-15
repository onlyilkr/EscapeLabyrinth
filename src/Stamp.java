public class Stamp {
	private int x;
	private int y;
	private int dist;

	public boolean equals(Object object){
		boolean same = false;
		if (object != null && object instanceof Stamp){
			same = this.x == ((Stamp) object).x && this.y == ((Stamp) object).y;
		}

			return same;
	}
	public Stamp(){
	}
	public Stamp(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Stamp(int x,int y,int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDist() {
		return dist;
	}
	public void setDist(int dist) {
		this.dist = dist;
	}
}
