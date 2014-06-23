function Reduce(key, values) {

	var result = {
		region : {
			location : {},
			i18n : {}
		},
		counterCompetitions : 0,
		counterEvents : 0
	};
	
	var counterCompetitionsAux = 0;
	var counterEventsAux = 0;
	
	result.region = values[0].region;
	values.forEach( function(value) {
		counterCompetitionsAux = counterCompetitionsAux + value.counterCompetitions; 
		counterEventsAux = counterEventsAux + value.counterEvents; 
	});
	result.counterCompetitions = counterCompetitionsAux;
	result.counterEvents = counterEventsAux;
	
	return result;
}