package PracticeArrays;

public class problemThree {
	
	public static void main(String[] args) {
		
		String s1 = "Hello World";
		
//		for(int i=s1.length()-1;i>=0;i--) {
//			System.out.print(s1.charAt(i)+" ");
//		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		System.out.println(sb.reverse());
		
		Dog d = new Dog("Pega","white","blue",3);
		System.out.println(d.getName()+" "+d.getColor()+" "+d.getEyeColor()+" "+d.getHeight());
	}

}

class Dog{
	
	String name;
	String color;
	String eyeColor;
	int height;
	
	public Dog(String name, String color, String eyeColor, int height) {
		this.name=name;
		this.color=color;
		this.eyeColor=eyeColor;
		this.height=height;
		
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public int getHeight() {
		return height;
	}
	
	
}
