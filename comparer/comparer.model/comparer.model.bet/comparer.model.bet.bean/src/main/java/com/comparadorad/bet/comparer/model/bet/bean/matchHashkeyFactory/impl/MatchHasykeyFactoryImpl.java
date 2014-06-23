package com.comparadorad.bet.comparer.model.bet.bean.matchHashkeyFactory.impl;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.MatchHashkeyGenerator;
import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.impl.MatchHashkeyGeneratorNoParticipants;
import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.impl.MatchHashkeyGeneratorParticipants;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

public class MatchHasykeyFactoryImpl extends AbstractMathHasykeyFactoryImpl {

	// @Inject
		// List<RtMatchHashkeyGenerator> generators;

		@Override
		public MatchHashkeyGenerator makeHashKeyGenerator(String sportId) {
			MatchHashkeyGenerator result = null;
			if (getNoParticipantIds().contains(sportId)) {
				result = new MatchHashkeyGeneratorNoParticipants();
			} else if (getParticipantIds().contains(sportId)) {
				result = new MatchHashkeyGeneratorParticipants();
			}

			// for (RtMatchHashkeyGenerator generator : generators) {
			// if (generator.getIds().contains(sportId)) {
			// result = generator;
			// break;
			// }
			// }

			return result;
		}

		private List<String> getNoParticipantIds() {
			List<String> ids = new ArrayList<String>();
			ids.add(CfgSportId.CYCLING.id());
			ids.add(CfgSportId.MOTOR.id());
			return ids;
		}

		private List<String> getParticipantIds() {
			List<String> ids = new ArrayList<String>();
			ids.add(CfgSportId.AMERICAN_FOOTBALL.id());
			ids.add(CfgSportId.BASEBALL.id());
			ids.add(CfgSportId.BASKETBALL.id());
			ids.add(CfgSportId.FOOTBALL.id());
			ids.add(CfgSportId.HANDBALL.id());
			ids.add(CfgSportId.ICE_HOCKEY.id());
			ids.add(CfgSportId.RUGBY_LEAGUE.id());
			ids.add(CfgSportId.TENNIS.id());
			return ids;
		}

}
