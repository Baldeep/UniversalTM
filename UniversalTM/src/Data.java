
public class Data {
	
	private String input = "0000";
	
	private String tm = "{q0,q1,q2,qa,qr}-{1}-{1,_}-{"
			+ "D(q0,0)=(q0,0,R);D(q0,1)=(q1,1,R);D(q0,_)=(qr,_,R);"
			+ "D(q1,0)=(q2,0,R);D(q1,1)=(q1,1,R);D(q1,_)=(qr,_,R);"
			+ "D(q2,0)=(q2,0,R);D(q2,1)=(qr,1,R);D(q2,_)=(qa,_,R)}-q0-qa-qr";

	// TM M2 accepts A = {0^2^n | n = 0, 1, 2, 3}
	private String tm1 = "{q1,q2,q3,q4,q5,qacc,qrej}-{0}-{0,X,_}-{"
			+ "D(q1,0)=(q2,_,R);D(q1,X)=(qrej,X,R);D(q1,_)=(qrej,_,R);"
			+ "D(q2,0)=(q3,X,R);D(q2,X)=(q2,X,R);D(q2,_)=(qacc,_,R);"
			+ "D(q3,0)=(q4,0,R);D(q3,X)=(q3,X,R);D(q3,_)=(q5,_,L);"
			+ "D(q4,0)=(q3,X,R);D(q4,X)=(q4,X,R);D(q4,_)=(qrej,_,R);"
			+ "D(q5,0)=(q5,0,L);D(q5,X)=(q5,X,L);D(q5,_)=(q2,_,R)}-q1-qacc-qrej";
	
	public String getTM(){
		return tm1;
	}
	
	public String getInput(){
		return input;
	}
	
	public boolean verbose(){
		return false;
	}
}
