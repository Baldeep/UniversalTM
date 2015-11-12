import java.util.List;
import java.util.Map;

public class UTM {
	public static void main(String[] args) {
		try {
			// Enter Input
			Parser p = new Parser("{q0,q1,q2}-{1}-{1,_}-{D(q0,1)=(q1,_,R);"
					+ "D(q0,_)=(q2,_,L);D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}-q0-q2-q3");
		
			// Initialize TM
			List<String> qs = p.getQ();
			List<Character> sigma = p.getInputAlphabet();
			List<Character> gamma = p.getMachineAlphabet();
			Map<State, NextState> delta = p.getStateTransitions();
			String q1 = p.getQ1();
			String qacc = p.getQacc();
			String qrej = p.getQrej();	
		
			String input = "0010010101";
			
			String q = q1;
			char[] in = input.toCharArray();
			while(q != qacc || q != qrej){
				int pointer = 0;
				// check that the string isn't finished.
				char c = in[pointer];
				if(c == '\0'){
					in = appendString(in);
					c = in[pointer];
				}
			}
		
		} catch (InvalidTMFormat e) {
			e.printStackTrace();
		}
	}
	
	public static char[] appendString(char[] in){
		String input = in.toString();
		for(int i = 0; i < 20; i++)
			input += " ";
		return input.toCharArray();
	}
}
