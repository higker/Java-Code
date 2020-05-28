package com.example.add;

import java.util.Random;
import java.util.Scanner;

public class Application {

	// 加法对象
	private static Additive ADD = new Additive();
	// 控制台输入
	private static Scanner input = new Scanner(System.in);
	// 记录错误次数
	private static int error = 0;
	// 记录答对次数
	private static int success = 0;
	// 重新答对的次数
	private static int reSuccess = 0;
	// 每题重答次数
	private static int recall = 0;
	// 当前次数
	private static int count = 0;
	// 总训练次数
	private static int total = 0;

	// 加法训练器入口
	public static void main(String[] args) {

		System.out.println("请输入本轮训练次数:");
		total = input.nextInt();
		System.out.println("请输错题重答次数:");
		recall = input.nextInt();
		// 开始循环训练
		for (int i = count; i < total; i++) {
			int num1 = randTwoNum();
			int num2 = randTwoNum();
			System.out.println("随机题目是:" + num1 + "+" + num2 + "= ?");
			checkSum(num1, num2);
		}
		
		System.out.println("本轮训练结束!本轮训练次数为:" + total + ",你正确答对了:" + success + "题,答错了:" + error + "题目.");
		System.out.println("本轮训练结束!本轮训练次数为:" + total + ",你重新答题了,使用重新答题次数为:" + reSuccess + "次.");
	}

	// 生成随机数
	public static int randTwoNum() {
		// 生成2位数的随机数并且返回
		return new Random().nextInt(100 - 1);
	}

	// 验证结果
	public static void checkSum(int num1, int num2) {
		ADD.addCompute(num1, num2);
		System.out.println("本题正确答案是:"+ADD.getSum());
		System.out.println("请输入你的计算结果:");
		int sum = input.nextInt();
		if (ADD.getSum() == sum) {
			success += 1;
		} else {
			error += 1;
			// 重新答题 每题有recall次数
			for (int j = 1; j < recall; j++) {
				System.out.println("你回答错误~,请重新答题:");
				int resum = input.nextInt();
				ADD.addCompute(num1, num2);
				reSuccess += 1;
				if(ADD.getSum() == resum) {
					break;
				}
			}
			System.out.println("重新答题次数用完了！！！请开始下一题:");
		}
	}
}
