package controller.injection;

public class Person {

	private String name;
	private String addr;
	private int age;
	
	public Person() {
		System.out.println("Person 기본 생성자");
	}

	public Person(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
		System.out.println("Person 인자생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("[이름: %s, 주소: %s, 나이: %d]", name, addr, age);
	}
	
}
