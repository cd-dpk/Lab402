abstract public class A {
	 private int value;
	 
	 public void print(A a){
		 System.out.println(a.value);
	 }
	 abstract public void printB();
}

class B extends A{
	@Override
	public void printB() {
		// TODO Auto-generated method stub
		System.out.println("B");
	}
	public static void main(String [] args) {
		for (int i = 0; i < 256; i++) {
			System.out.println(i+" "+ (char)i);
		}
	}
	
}