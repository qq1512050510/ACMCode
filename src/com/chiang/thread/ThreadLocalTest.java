package com.chiang.thread;

public class ThreadLocalTest implements Runnable {

	private String name;
	private int i = 1;

	public ThreadLocalTest(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(name + i++);

	}

	public static void main(String[] args) {
		ThreadLocalTest threadTest1 = new ThreadLocalTest("a");
		ThreadLocalTest threadTest2 = new ThreadLocalTest("b");
		ThreadLocalTest threadTest3 = new ThreadLocalTest("c");
		threadTest1.run();
		threadTest2.run();
		threadTest3.run();
		threadTest1.run();
	}

}
