public class Node {
	private int x;
	private int y;
	private int dist;
	
	public Node(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Node(int x,int y,int dist){
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
