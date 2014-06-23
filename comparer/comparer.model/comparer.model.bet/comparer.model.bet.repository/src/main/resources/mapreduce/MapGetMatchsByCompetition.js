function Map() {
	var match = this;
	var markets = match.markets;
	var market;

	var marketBetTypeId;
	var marketbetTypeEventId;
	
	markets.forEach(function(value) {
		marketBetTypeId = value.betType.$id;
		marketbetTypeEventId = value.betTypeEvent.betTypeEvent.$id;
		if (marketBetTypeId == betTypeId) {
			if(betTypeEventId!=null && betTypeEventIdPCP!=null) {
				if(marketbetTypeEventId ==betTypeEventId || marketbetTypeEventId ==betTypeEventIdPCP) {
					market = value;
				}
			} else if(betTypeEventId!=null) {
				if(marketbetTypeEventId ==betTypeEventId) {
					market = value;
				}
			} else{
				market = value;
			}	
		}
	});

	while (match.markets.length > 0) {
		match.markets.pop();
	}
	if (market != null) {
		match.markets.push(market);
	}

	if (match.markets.length == 0) {
		match = null;
	}

	emit(this._id, match);
}