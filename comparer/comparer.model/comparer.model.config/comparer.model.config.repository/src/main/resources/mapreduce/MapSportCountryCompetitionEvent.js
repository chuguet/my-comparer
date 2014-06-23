function Map() {
	//Para activar la lectura con clusters de mongo
	rs.slaveOk();
	
	/*
	    this, representa el elemento actual de la coleccion
		La funcion emit tiene dos parametros:
		- key  : valor unico
		- json : datos
		
		Asi como dos caracteristicas importantes (para reducir los elementos de una clave)
		- El valor creado es la entrada de la funcion reduce
		- Se ejecuta tantas veces la funcion reduce como key distinto.		
	*/
	// Definicion de variables (Las variables javascript son tipadas)
	var regionId = this.region.$id;
	var competitionId = this._id;	
	
	// Resultado, estructura JSon que se devolvera con cada elemento del map. 
	var result = {
		region : {
			location : {},
			i18n : {}
		},
		counterCompetitions : 0,
		counterEvents : 0
	};
	
// Dejo esto porque es un ejemplo de como rellenar estructuras por dentro.	
//	var eventQuery = {
//		$or : [
//		],
//		$and : [
//		]
//	};
	
	// Para consultar por region
	var regionQuery = {
		"_id" : regionId
	};
	
	var counterCompetitionAux = 0;
	var counterEventAux = 0;
	var i18n;
	var cursor;
	var element;
	
	// Consulta: en RtMatch, por la competicion pasada: compeitionId
	// "matchId.competitionEvent.$id" : "1": Corto Plazo.
	var strTmp = { 
		"matchId.competition.$id" : competitionId,
		"matchId.startDate.zeroGmtMatchDate" :
		{
			$gt : new Date()
		},
		"matchId.competitionEvent.$id" : "1",
		"coreActiveElement.active" : true
	};
//	$or: [ {"markets.betTypeEvent.betTypeEvent.$id" : "1"}, 
//		   {"markets.betTypeEvent.betTypeEvent.$id" : "17"}]

//	eventQuery.$or.push( strTmp );
	cursor = db.rtMatch.find( strTmp );
	if(cursor.size()>1) {
		counterCompetitionAux = 1;
	}	
	
	//Recorrer los distintos valores devuelvo por el cursor
	while( cursor.hasNext() ){
		element = cursor.next();
		counterEventAux += 1;		
	}

	// Consultar y recorrer los elementos de la region
	cursor = db.cfgRegion.find( regionQuery );
	if( cursor.hasNext() ){
		element = cursor.next();
	}
	
	// Asignar valores a un objecto Json
	result.region.location = element.alfanumeric2Code;
	result.region.i18n = element.i18n;
	result.counterCompetitions = counterCompetitionAux;
	result.counterEvents = counterEventAux;
	if(this.region.$id==724){print(tojson(result));}
	emit(this.region.$id, result);
}
