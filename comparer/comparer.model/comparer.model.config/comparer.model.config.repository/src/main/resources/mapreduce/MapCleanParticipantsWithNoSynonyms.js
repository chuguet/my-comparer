function Map() {
	//Para activar la lectura con clusters de mongo
	rs.slaveOk();

	var result = {
		counterSynonyms: {},
		synonymsIdList:{}
	};
	
	var eventQuery = {
		"participant.$id" : this._id
	};
	
	var counterEvent = 0;
	var synonymIds = [];
	
	var cursor = db.cfgParticipantSynonyms.find(eventQuery);
	
	while( cursor.hasNext() ){
		element = cursor.next();
		counterEvent = counterEvent + 1;
		synonymIds.push(element._id);		
	}

	result.counterSynonyms = counterEvent;
	result.synonymsIdList = synonymIds;
	
	if (counterEvent==0){
		emit(this._id,result);	
	}	
}