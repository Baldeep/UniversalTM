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
	private List<Character> rho;
	private Map<State, NextState> delta;
	
	private String q1;
	private String qacc;
	private String qrej;
	
	public Parser(String input) throws InvalidTMFormat{
		parse(input);
		qs = new ArrayList<String>();
		sigma = new ArrayList<Character>();
		rho = new ArrayList<Character>();
		delta = new HashMap<State, NextState>();
	}
	
	private void setInput(String input){
		
	}
	
	private void parse(String input) throws InvalidTMFormat{
		String[] split = input.split("-");
		for(int i=0; i < split.length; i++){
			System.out.println(split[i]);
		}
		qs = getStringArray(split[0]);
		sigma = getCharArray(split[1]);
		rho = getCharArray(split[2]);
	}
	
	private List<String> getStringArray(String input){
		String[] qs = input.substring(1, input.length()-1).split(",");
		return Arrays.asList(qs);
	}
	
	private List<Character> getCharArray(String input) throws InvalidTMFormat{
		List<Character> chars = new ArrayList<>();
		
		List<String> parsed = getStringArray(input);
		
		for(int i = 0; i < parsed.size(); i++){
			if(parsed.get(i).length() == 1){
				chars.add(parsed.get(i).charAt(0));
			} else if(parsed.get(i).contains(" ")){
				throw new InvalidTMFormat("Wrong format at Sigma[" + i 
						+ "]: cannot have spaces");
			} else {
				throw new InvalidTMFormat("Wrong format at Sigma[" + i 
						+ "]: can only be length of 1, is " + parsed.get(i).length());
			}	
		}
		
		return chars;
	}
	
	
// {q0,q1,q2}-{1}-{1,_}-{D(q0,1)=(q1,_,R);D(q0,_)=(q2,_,L);D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}-q0-q2-q3
}
