function Map() {
	//Para activar la lectura con clusters de mongo
	rs.slaveOk();

	/* 
	La funcion emit tiene dos parametros:
	- key  : valor unico
	- json : datos
	
	La funcion emit tiene dos caracteristicas importantes:
	- El valor creado es la entrada de la funcion reduce
	- Se ejecuta tantas veces la funcion reduce como key distinto.
	*/
	var result = {
		counterEvents : 0
	};
	var eventQuery = {
		$or : [
		],
		$and : [
		]
	};
	var dateActiveFilter = {
		"coreActiveElement.active":true,
		"matchId.startDate.zeroGmtMatchDate" :
		{
			$gt : new Date()
		}
	};
	var counterEventAux = 0;
	var cursor;
	var element;
	var competitionQuery = { 
		"matchId.competition.$id" : this._id
	};
	
	eventQuery.$or.push(competitionQuery);
	eventQuery.$and.push(dateActiveFilter);
	
	/*
		Relizar una consulta a otra coleccion
	*/
	cursor = db.rtMatch.find( eventQuery, { "_id" : 1 } );
	/*
		Recorrer los distintos valores devuelvo por el cursor
	*/	
	while( cursor.hasNext() ){
		element = cursor.next();
		counterEventAux += 1;		
	}
	
	/*
		Asignar valores a un objecto Json
	*/		
	result.counterEvents = counterEventAux;
	
	emit(this.sport.$id, result);
}