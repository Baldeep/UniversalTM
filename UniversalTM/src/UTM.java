import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UTM {

	private static int LIMIT = 200;

	public static void main(String[] args) {
		try {
			
			String input = "00000";

			String tm = "{q0,q1,q2,qa,qr}-{1}-{1,_}-{"
					+ "D(q0,0)=(q0,0,R);D(q0,1)=(q1,1,R);D(q0,_)=(qr,_,R);"
					+ "D(q1,0)=(q2,0,R);D(q1,1)=(q1,1,R);D(q1,_)=(qr,_,R);"
					+ "D(q2,0)=(q2,0,R);D(q2,1)=(qr,1,R);D(q2,_)=(qa,_,R)}-q0-qa-qr";

			// TM M2 accepts A = {0^2^n | n = 0, 1, 2, 3}
			String tm1 = "{q1,q2,q3,q4,q5,qacc,qrej}-{0}-{0,X,_}-{"
					+ "D(q1,0)=(q2,_,R);D(q1,X)=(qrej,X,R);D(q1,_)=(qrej,_,R);"
					+ "D(q2,0)=(q3,X,R);D(q2,X)=(q2,X,R);D(q2,_)=(qacc,_,R);"
					+ "D(q3,0)=(q4,0,R);D(q3,X)=(q3,X,R);D(q3,_)=(q5,_,L);"
					+ "D(q4,0)=(q3,X,R);D(q4,X)=(q4,X,R);D(q4,_)=(qrej,_,R);"
					+ "D(q5,0)=(q5,0,L);D(q5,X)=(q5,X,L);D(q5,_)=(q2,_,R)}-q1-qacc-qrej";

			// Enter Input
			Parser p = new Parser(tm1);

			// Initialize TM
			List<String> qs = p.getQ();
			List<Character> sigma = p.getInputAlphabet();
			List<Character> gamma = p.getMachineAlphabet();
			HashMap<State, NextState> delta = (HashMap<State, NextState>) p.getStateTransitions();
			String q1 = p.getQ1();
			String qacc = p.getQacc();
			String qrej = p.getQrej();	

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

					System.out.println("\u03B4(" + s.getState() + "," + s.getInput() + ")=(" 
							+ ns.getState() + "," + ns.getOutput() + "," + ns.getDirection() + ")");

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
		for(int i = 0; i<5; i++)
			input+="_";
		return input.toCharArray();
	}

}
