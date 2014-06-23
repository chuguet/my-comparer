function Map() {
	//Para activar la lectura con clusters de mongo
	rs.slaveOk();

	/*
		Definicion de una variable que contiene un json	
	*/
	var result = {
		counter: {},
		i18n : {}
	};
	
	var eventQuery = {
		"coreActiveElement.active":true,
		"matchId.competition.$id" : this._id,
		"matchId.startDate.zeroGmtMatchDate" :
		{
			$gt : new Date()
		},
		"matchId.competitionEvent.$id" : "2"
	};
	
	var counterEvent = 0;
	
	var cursor = db.rtMatch.find( eventQuery, {  "_id" : 1 } );	
	
	while( cursor.hasNext() ){
		element = cursor.next();
		counterEvent = counterEvent + 1;		
	}
	
	var cursor = db.rtMatch.find( eventQuery, {  "_id" : 1 } );	
	
	
	result.i18n = this.i18n;
	result.counter = counterEvent;
	emit(this._id,result);	
	
}