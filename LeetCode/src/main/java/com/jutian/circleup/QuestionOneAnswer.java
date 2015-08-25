package com.jutian.circleup;

import java.util.Collection;

public class QuestionOneAnswer implements QuestionAnswer {

	@Override
	public void answer(Collection<Result> results) {
		int count = 0;
		for (Result result : results) {
			if (result.isFound()) {
				count++;
			}
		}
		System.out.println(count + " words are matched");
	}

}
