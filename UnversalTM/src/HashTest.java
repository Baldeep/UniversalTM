import java.util.HashMap;
import java.util.Map;

public class HashTest {

	public static void main(String[] args) {
		State s1 = new State("q1", '1');
		State s2 = new State("q2", '2');
		State s3 = new State("q1", '1');
		State s4 = new State("q1", '2');
		State s5 = new State("q1", '2');
		State s6 = new State("q1", '1');
		
		Map<State, Integer> map = new HashMap<>();
		map.put(s1, 1);
		map.put(s2, 2);
		map.put(s4, 3);
		
		System.out.println("s1 hash: " + s1.hashCode());
		System.out.println("s3 hash: " + s3.hashCode());
		
		System.out.println("s4 hash: " + s4.hashCode());
		System.out.println("s5 hash: " + s5.hashCode());
		
		System.out.println("contains: " + map.containsKey(s3));
		System.out.println("get: " + map.get(s3));
		
		System.out.println("contains: " + map.containsKey(s5));
		System.out.println("get: " + map.get(s5));
		
		/*
		 * s1 = s4 = (q1, 1), s5 = (q3, 1) 
		 * s3 = true, 3, s5 = false
		 * 
		 * s1 = (q1, 1), s4 = (q3, 1), s5 = (q3, 1) 
		 * s3 = true, 1, s5 = true, 3
		 * 
		 * s1 = (q1, 1), s4 = (q1, 2), s5 = (q1, 2) 
		 * s3 = true, 1, s5 = true, 3
		 * 
		 */
	}

}
