import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UTMain {

	private static int LIMIT = 500;

	public static void main(String[] args) {
		try {
			Data d = new Data();
			String input;

			String tm = d.getTM();

			// Enter Input
			Parser p = new Parser(tm);

			// Initialize TM
			List<String> qs = p.getQ();
			List<Character> sigma = p.getInputAlphabet();
			List<Character> gamma = p.getMachineAlphabet();
			HashMap<State, NextState> delta = (HashMap<State, NextState>) p.getStateTransitions();
			String q1 = p.getQ1();
			String qacc = p.getQacc();
			String qrej = p.getQrej();	
			
			if(p.getInput() != null)
				input = p.getInput();
			else 
				input = d.getInput();

			System.out.println();

			int lim = 0;

			char[] in = inputToArray(input);
			String q = q1;
			int pointer = 0;

			while(!q.equals(qacc) && !q.equals(qrej)){

				// check that the string isn't finished.
				if(pointer >= in.length){
					in = appendString(in);
				}
				
				printConfig(q, pointer, in);

				char c = in[pointer];

				if(!gamma.contains(c)){
					q=qrej;
				} else {

					State s = new State(q, c);
					NextState ns = delta.get(s);
					
					if(d.verbose()){
					System.out.println("\u03B4(" + s.getState() + "," + s.getInput() + ")=(" 
							+ ns.getState() + "," + ns.getOutput() + "," + ns.getDirection() + ")");
					}
					
					q = ns.getState();
					in[pointer]=ns.getOutput();
					if(ns.getDirection() == Direction.R)
						pointer++;
					else if(ns.getDirection() == Direction.L && pointer > 0)
						pointer--;

					lim++;
					if(lim > LIMIT){
						q = qrej;
					}
				}
			}

			if(q.equals(qacc))
				System.out.println("accept");
			else
				System.out.println("reject");

		} catch (InvalidTMFormat e) {
			e.printStackTrace();
		}
	}

	public static void printConfig(String q, int pointer, char[] input){
		for(int i = 0; i < pointer; i++)
			System.out.print(input[i]);
		System.out.print("" + q + "'");
		for(int i = pointer; i<input.length; i++)
			System.out.print(input[i]);
		System.out.print("\n");
	}

	public static char[] inputToArray(String input){
		char[] in = input.toCharArray();
		for(char i : in){
			if(i == ' ')
				i = '_';
		}
		return in;
	}
	public static char[] appendString(char[] in){
		String input = "";
		for(char c : in)
			input += c;
		for(int i = 0; i<3; i++)
			input+="_";
		return input.toCharArray();
	}

}
