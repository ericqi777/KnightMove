package com.jutian.circleup;

import java.util.Collection;

public class QuestionTwoAnswer implements QuestionAnswer {

	@Override
	public void answer(Collection<Result> results) {

		String first = "";
		String last = null;
		String curr = null;
		boolean compared = false;
		int rst = 0;
		int index = 0;
		
		for(Result result : results){
			if(result.isFound()){
				curr = result.getWord();
				compared = false;
				if (curr.length()>first.length()){
					first = curr;
				}
				else if(curr.length() == first.length()){					
					while (rst == 0 && index < first.length()) {
						rst = first.charAt(index) - curr.charAt(index);
						if (rst > 0 && !compared) {
							first = curr;
							compared = true;
						}
						index++;
					}
				}
			}
		}
		
		rst = 0;
		last = first;
		index = 0;
		for(Result result : results){
			if(result.isFound() && result.getWord()!= last){
				curr = result.getWord();
				compared = false;
				if(curr.length() < last.length()){
					last = curr;
				}
				else if(curr.length() == last.length()){
					while (rst == 0 && index < last.length()){
						rst = last.charAt(index) - curr.charAt(index);
						if( rst < 0 && !compared) {
							last = curr;
							compared = true;
						}
						index++;
					}
				}
			}
		}
		
		System.out.println("Answer of question 2:");
		System.out.println("The first printout is: " + first);
		System.out.println("The last printout is: " + last);
		
	}

}
