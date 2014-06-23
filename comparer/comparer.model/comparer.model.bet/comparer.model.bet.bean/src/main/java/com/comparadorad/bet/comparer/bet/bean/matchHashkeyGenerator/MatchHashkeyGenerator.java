package com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

public interface MatchHashkeyGenerator {

	String getHashKey(RtMatch Match);

	List<String> getIds();

}
