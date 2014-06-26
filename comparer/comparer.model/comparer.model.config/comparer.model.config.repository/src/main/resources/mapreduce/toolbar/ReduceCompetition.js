function Reduce(key, values) {

	var result = {
		counterEvents : 0
	};
	
	var counterEventsAux = 0;
	
	values.forEach( function(value) {
		counterEventsAux = counterEventsAux + value.counterEvents; 
	});
	result.counterEvents = counterEventsAux;
	
	return result;
}