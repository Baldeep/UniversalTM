
public class UTM {
	public static void main(String[] args) {
		Parser p = new Parser("{q0,q1,q2}-{1}-{1,_}-{D(q0,1)=(q1,_,R);"
				+ "D(q0,_)=(q2,_,L);D(q1,1)=(q0,1,R);D(q1,_)=(q3,_,R)}-q0-q2-q3");
	}
}