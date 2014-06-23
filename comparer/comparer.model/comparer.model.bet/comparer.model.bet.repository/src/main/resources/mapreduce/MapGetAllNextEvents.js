function Map() {
    var market = {
					numBets:0,
					betType:{}
				 }
	var result = {
					markets : [],
					date : {}
				 }
	
	result.date = this.matchId.startDate.zeroGmtMatchDate;
	for each (var cursor in this.markets){
		if ((cursor.betTypeEvent.betTypeEvent.$id==1 && 
				((cursor.betType.$id==1 && cursor.bets.length>=minimalNumberOfBookamkers*3) || (cursor.betType.$id==2 && cursor.bets.length>=minimalNumberOfBookamkers*2)))
			||
		   (cursor.betTypeEvent.betTypeEvent.$id==17 && cursor.betType.$id==2 && cursor.bets.length>=minimalNumberOfBookamkers*2)){
			market.numBets = cursor.bets.length;
			market.betType = cursor.betType.$id;
			result.markets.push(market);
		}
	};
	
	emit(this._id, result);
}