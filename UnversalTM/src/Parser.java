import java.util.ArrayList;
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
	
	private ArrayList<String> qs;
	private ArrayList<Character> sigma;
	private ArrayList<Character> rho;
	private Map<State, NextState> delta;
	
	private String q1;
	private String qacc;
	private String qrej;
	
	public Parser(String input){
		parse(input);
		qs = new ArrayList<String>();
		sigma = new ArrayList<Character>();
		rho = new ArrayList<Character>();
		delta = new HashMap<State, NextState>();
	}
	
	private void parse(String input){
		String[] split = input.split("-");
		for(int i=0; i < split.length; i++){
			System.out.println(split[i]);
		}
		qs = getQs(split[0]);
	}
	
	private ArrayList<String> getQs(String input){
		System.out.println("Qs: " + input);
		ArrayList<String> qs = new ArrayList<String>();
		
		
		return qs;
	}
	
// {q0,q1,q2}-{1}-{1,_}-{D(q0,1)=(q1,_,R);D(q0,_)=(q2,_,L);D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}-q0-q2-q3
}
