package com.jutian.circleup;

import java.util.Collection;

public class QuestionOneAnswer implements QuestionAnswer {

	@Override
	public void answer(Collection<Result> results) {
		int count = 0;
		for (Result result : results) {
			if (result.isFound()) {
				//System.out.println(result.getWord());
				count++;
			}
		}
		System.out.println("Answer of Question 1: ");
		System.out.println(count + " words are matched");
		System.out.println();
	}

}
