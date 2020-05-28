package com.example.add;

// 加法运算对象
public class Additive {
	// 成员变量
	private int Number, AsNumber; // 加数和被加数
	private int Sum; // 和数

	public Additive() {
		super();
	}

	// 构造函数
	public Additive(int number, int asNumber) {
		super();
		Number = number;
		AsNumber = asNumber;
	}

	// 加法计数器
	public void addCompute() {
		// 把2个数的结果加起来存到和里面
		int sum = this.getNumber() + this.getAsNumber();
		this.setSum(sum);
	}

	// 加法计数器
	public void addCompute(int number, int asNumber) {
		this.setNumber(number);
		this.setAsNumber(asNumber);
		// 把2个数的结果加起来存到和里面
		int sum = this.getNumber() + this.getAsNumber();
		this.setSum(sum);
	}

	public int getNumber() {
		return this.Number;
	}

	public void setNumber(int number) {
		this.Number = number;
	}

	public int getAsNumber() {
		return this.AsNumber;
	}

	public void setAsNumber(int asNumber) {
		this.AsNumber = asNumber;
	}

	public int getSum() {
		return this.Sum;
	}

	public void setSum(int sum) {
		this.Sum = sum;
	}

}
