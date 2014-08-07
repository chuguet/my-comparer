var generic = {
	"uri" : "/com.comparadorad.bet.comparer.web.server.portlet.systemHour/SystemHourModule/rest/",
	"post" : function(action, params, callback) {
		this.executeJSon('POST', action, params, callback);
	},
	"showInformation" : function() {
		var information = arguments[0];
		showInformationIntoView(information);
	},
	"executeJSon" : function($method, action, data, callback) {
		if (data != null) {
			data = JSON.stringify(data);
		}

		$.ajaxSetup({
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json'
			}
		});
		
		$.ajax({
			type : $method,
			url : generic.uri + action,
			data : data,
			dataType : 'json',
			success : function(response) {
				if (callback) {
					var param = new Array();
					param.push(response);
					callback.apply(this, param);
				}
			},
			error : function(e) {
			}
		});
	}
};