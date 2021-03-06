
public class NextState {

	private String q;
	private char output;
	private Direction direction;
	
	public NextState(String q, char output, Direction direction){
		this.q = q;
		this.output = output;
		this.direction = direction;
	}
	
	public String getState(){
		return q;
	}
	
	public char getOutput(){
		return output;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	@Override
	public boolean equals(Object o){
		if( o instanceof NextState){
			return(this.q.equals(((NextState) o).getState()) 
					&& this.output == ((NextState) o).getOutput() 
					&& this.direction == ((NextState) o).getDirection());
		}
		return false;
	} 
	
	@Override public int hashCode() {
        return (41 * (41 + getState().length()) + 7 * getOutput());
    }
	
}

