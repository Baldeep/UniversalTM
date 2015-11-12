import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
	
	/*
	 * {q0,q1,q2}-{1}-{1,_}-
	 * {D(q0,1)=(q1,_,R);D(q0,_)=(q2,_,L);
	 * D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}
	 * -q0-q2-q3
	 */
	
	private List<String> qs;
	private List<Character> sigma;
	private List<Character> gamma;
	private Map<State, NextState> delta;
	
	private String q1;
	private String qacc;
	private String qrej;
	
	public Parser(String input) throws InvalidTMFormat{
		parse(input);
		qs = new ArrayList<String>();
		sigma = new ArrayList<Character>();
		gamma = new ArrayList<Character>();
		delta = new HashMap<State, NextState>();
	}
	
	public void setInput(String input) throws InvalidTMFormat{
		parse(input);
	}
	
	public List<String> getQ(){
		return qs;
	}
	
	public List<Character> getInputAlphabet(){
		return sigma;
	}
	
	public List<Character> getMachineAlphabet(){
		return gamma;
	}
	
	public Map<State, NextState> getStateTransitions(){
		return delta;
	}
	
	public String getQ1(){
		return q1;
	}
	
	public String getQacc(){
		return qacc;
	}
	
	public String getQrej(){
		return qrej;
	}
	
	public void printTM(){
		System.out.println("Q: " + qs);
		System.out.println("\u03A3: " + sigma);
		System.out.println("\u0393: " + gamma);
		System.out.println(": " +delta.toString());
		System.out.println("q1: " + q1);
		System.out.println("qacc: " + qacc);
		System.out.println("qrej: " + qrej);
	}
	
	private void parse(String input) throws InvalidTMFormat{
		String[] split = input.split("-");
		
		if(split.length != 7){
			throw new InvalidTMFormat("String must be a 7-uple, is a " 
					+ split.length + "-uple");
		}
		
		for(int i=0; i < split.length; i++){
			System.out.println(split[i]);
		}
		
		qs = getStringArray(split[0]);		
		sigma = getCharArray(split[1]);		
		gamma = getCharArray(split[2]);	
		delta = getStateMap(split[3]);
		q1 = split[4];	
		qacc = split[5];
		qrej = split[6];
	}
	
	
	private List<String> getStringArray(String input) throws InvalidTMFormat{
		String[] qs = input.substring(1, input.length()-1).split(",");
		for(int i = 0; i < qs.length; i++){
			if(qs[i].contains(" ")){
				throw new InvalidTMFormat("Wrong format at Q[" + i 
						+ "]: cannot have spaces");
			}
		}
		return Arrays.asList(qs);
	}
	
	private List<Character> getCharArray(String input) throws InvalidTMFormat{
		List<Character> chars = new ArrayList<>();
		
		List<String> parsed = getStringArray(input);
		
		for(int i = 0; i < parsed.size(); i++){
			if(parsed.get(i).length() == 1){
				chars.add(parsed.get(i).charAt(0));
			} else if(parsed.get(i).contains(" ")){
				throw new InvalidTMFormat("Wrong format at Sigma or Gamma [" + i 
						+ "]: cannot have spaces");
			} else {
				throw new InvalidTMFormat("Wrong format at Sigma or Gamma [" + i 
						+ "]: can only be length of 1, is " + parsed.get(i).length());
			}	
		}
		
		return chars;
	}
	
	private Map<State, NextState> getStateMap(String input) throws InvalidTMFormat{
		Map<State, NextState> map = new HashMap<>();
		
		String[] parsed = input.substring(1, input.length()-1).split(";");
		
		for(int i=0; i < parsed.length; i++){
			String[] temp = parsed[i].split("=");
			String[] state = temp[0].substring(2, temp[0].length()-1).split(",");
			String[] nextState = temp[1].substring(1, temp[1].length()-1).split(",");

			// Check state for '='
			if(temp.length != 2)
				throw new InvalidTMFormat("Wrong state format at state " + i + ": too many '='");
		
			// Check the strings contain the right number of things
			if(temp.length != 2 || state.length != 2 || nextState.length != 3)
				throw new InvalidTMFormat("Wrong state format at state " + i);
			
			// D(q1, E), ensure E is a char
			if(state[1].length() != 1)
				throw new InvalidTMFormat("Alphabet not char " + i);
			State st = new State(state[0], state[1].charAt(0));
			
			// D=(q1, E, Dir), ensure E is a char
			if(nextState[1].length() != 1)
				throw new InvalidTMFormat("Alphabet not char " + i);
			// D=(q1, E, Dir), ensure Dir is a char
			if(nextState[2].length() != 1)
				throw new InvalidTMFormat("Wrong format at state " + i + ": direction can only be a char");
			Direction dir; 
			if(nextState[2].charAt(0) == 'R')
				dir = Direction.R;
			else if(nextState[2].charAt(0) == 'L')
				dir = Direction.L;
			else
				throw new InvalidTMFormat("Wrong format at state " + i + ": direction can only be 'R' or 'L'");
			
			NextState ns = new NextState(nextState[0], nextState[1].charAt(0), dir);
			
			map.put(st, ns);
		}
		
		return map;
	}
	
	
// {q0,q1,q2}-{1}-{1,_}-{D(q0,1)=(q1,_,R);D(q0,_)=(q2,_,L);D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}-q0-q2-q3
}
