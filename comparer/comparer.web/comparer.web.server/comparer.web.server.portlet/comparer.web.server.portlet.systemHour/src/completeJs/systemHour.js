var systemHour = {
	'calculateUser' : function(gmt, userId) {
		var data = {
			gmt : gmt,
			userId : userId
		};
		generic.post('systemHour/calculateHourUser', data,
				generic.showInformation);
	},
	'calculateNotUser' : function(gmt) {
		var data = {
			gmt : gmt
		};
		generic.post('systemHour/calculateHourNotUser', data,
				generic.showInformation);
	}
}

function timer() {
	var sdf = new JsSimpleDateFormat("dd/MM/yyyy HH:mm");
	var fecha = sdf.parse($("#fecha").val());
	fecha = new Date(fecha.getTime() + 60000);
	$("#fecha").val(sdf.format(fecha));
}

function load() {
	makeCookie();
}

function makeCookie() {
	var cookieName = 'USER_TIMEZONE';
	var cookieValue = $("#timezones").val();
	setCookie('USER_TIMEZONE', cookieValue, 30);
}

function onChangeGMT() {
	var gmt = $("#timezones").val();
	var userId = $("#userId").val();
	if (userId != null && userId != "") {
		systemHour.calculateUser(gmt, userId);
	} else {
		systemHour.calculateNotUser(gmt);
	}
	var cookieName = 'USER_TIMEZONE';
	var cookieValue = gmt;
	setCookie(cookieName, cookieValue, 30);
}

function showInformationIntoView(information) {
	$("#fecha").val(information.systemHour);
	location.reload();
}