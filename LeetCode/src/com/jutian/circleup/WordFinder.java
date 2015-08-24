package com.jutian.circleup;

import java.util.Collection;

public interface WordFinder {

	Collection<Result> run(Collection<String> words, String[][] metrix);
} 
