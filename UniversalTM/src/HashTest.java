import java.util.HashMap;
import java.util.Map;

public class HashTest {

	public static void main(String[] args) {
		State s1 = new State("q1", 'c');
		State s2 = new State("q2", '2');
		State s3 = new State("q1", '1');
		State s4 = new State("q1", '2');
		State s5 = new State("q1", '2');
		
		NextState ns1 = new NextState("q1", 'c', Direction.R);
		NextState ns2 = new NextState("q2", ' ', Direction.L);
		NextState ns3 = new NextState("q1", '2', Direction.R);
		NextState ns4 = new NextState("q3", '1', Direction.L);
		NextState ns5 = new NextState("q1", 'c', Direction.R);
		
		
		Map<State, NextState> map = new HashMap<>();
		map.put(s1, ns1);
		map.put(s2, ns2);
		map.put(s4, ns1);
		
		System.out.println("s1 hash: " + s1.hashCode());
		System.out.println("ns1 hash: " + ns1.hashCode());
		System.out.println("ns3 hash: " + ns3.hashCode());
		System.out.println("ns5 hash: " + ns5.hashCode());
		System.out.println("s1 = ns1: " + s1.equals(ns1));
		System.out.println("ns1 = ns5: " + ns1.equals(ns5));
		
		NextState t1 = map.get(s1);
		System.out.println("check found: " + ns1.equals(t1));
		System.out.println("t1 = (" + t1.getState() + ", " 
									+ t1.getOutput() + ", " 
									+ t1.getDirection() + ")");
	}
	
	public static void testKeys(){
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
