package com.chiang.spring.test.annotation;

import org.springframework.stereotype.Component;

@Component
public class SgtPepper implements CompactDisc {

	private String title = "Sgt, Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		System.out.printf("Playing %s by %s\n", title, artist);
	}
	public static void main(String[] args) {
		CompactDisc sgtPepper = new SgtPepper();
		sgtPepper.play();
	}

}
