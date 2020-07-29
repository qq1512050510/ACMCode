package com.chiang.spring.test.di;

import com.chiang.spring.test.di.inter.Quest;

public class BraveKnight {

	private Quest quest;

	//Quest被注入进来
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public void embarkOnQuest() {
		quest.embark();
	}
}
