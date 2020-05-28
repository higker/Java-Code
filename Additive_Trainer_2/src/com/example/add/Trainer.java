package com.example.add;

import java.util.Random;
import java.util.Scanner;

// 计量器对象
public class Trainer {
	// 加法对象
	private static Additive ADD = new Additive();
	// 控制台输入
	private static Scanner INPUT = new Scanner(System.in);
	// 记录错误次数
	private static int ERROR = 0;
	// 记录答对次数
	private static int SUCCESS = 0;
	// 重新答对的次数
	private static int RESUCCESS = 0;
	// 每题重答次数
	private static int RECALL = 0;
	// 当前次数
	private static int COUNT = 0;
	// 总训练次数
	private static int TOTAL = 0;
	// 记录文件保存地址
	private static String PATH = "";

	public void start() {
		System.out.println("请输入本轮训练次数:");
		TOTAL = INPUT.nextInt();
		System.out.println("请输入错题重答次数:");
		RECALL = INPUT.nextInt();
		System.out.println("请输入记录文件存储地址(完整路径):");
		PATH = INPUT.next();
		// 开始循环训练
		for (int i = COUNT; i < TOTAL; i++) {
			int num1 = randTwoNum();
			int num2 = randTwoNum();
			System.out.println("随机题目是:" + num1 + "+" + num2 + "= ?");
			checkSum(num1, num2);
		}
		System.out.println("本轮训练结束!本轮训练次数为:" + TOTAL + ",你正确答对了:" + SUCCESS + "题,答错了:" + ERROR + "题目.");
		System.out.println("本轮训练结束!本轮训练次数为:" + TOTAL + ",你重新答题了,使用重新答题次数为:" + RESUCCESS + "次.");
	}

	// 生成随机数
	public static int randTwoNum() {
		// 生成2位数的随机数并且返回
		// 随机源是 50以内里面取 加10是防止生成个位数的
		// LJLS Deen WSD
		return new Random().nextInt(50 - 1) + 10;
	}

	// 记录文件
	public static void recordErr(int num1, int num2, int sum) {
		String template = num1 + "+" + num2 + " = ? 你本题答错了,你的答案是:" + sum + "\r\n";
		util.writer(PATH, template);
	}
	
	
	
	// 验证结果
	public static void checkSum(int num1, int num2) {
		ADD.addCompute(num1, num2);
		System.out.println("本题正确答案是:" + ADD.getSum());
		System.out.println("请输入你的计算结果:");
		int sum = INPUT.nextInt();;		
		if (ADD.getSum() == sum) {
			SUCCESS += 1;
		} else {
			ERROR += 1;
			//记录你输入的错误消息
			recordErr(num1, num2, sum);
			// 重新答题 每题有recall次数
			for (int j = 1; j < RECALL; j++) {
				System.out.println("你回答错误~,请重新答题:");
				int resum = INPUT.nextInt();
				ADD.addCompute(num1, num2);
				RESUCCESS += 1;
				if (ADD.getSum() == resum) {
					break;
				}
			}
			System.out.println("重新答题次数用完了！！！请开始下一题:");
		}
	}
}
