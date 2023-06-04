
package question;

public class House {
	
	private String name;
	private int x;
	private int y;
	
	/* Create Getters, setters for the House class for each attribute */
	
	public House(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	public House() {
		name="empty";
		x=0;
		y=0;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "House [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
	



	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	
	
}

