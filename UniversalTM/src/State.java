
public class State {
	private String q;
	private char input;
	
	public State(String q, char input){
		this.q = q;
		this.input = input;
	}
	
	public String getState(){
		return q;
	}
	
	public char getInput(){
		return input;
	}
	
	@Override
	public boolean equals(Object o){
		if( o instanceof State){
			return(this.q.equals(((State) o).getState()) && this.input == ((State) o).getInput());
		}
		return false;
	} 
	
	@Override public int hashCode() {
        return (41 * (41 + getState().length()) + 7 * getInput());
    }
	
}
