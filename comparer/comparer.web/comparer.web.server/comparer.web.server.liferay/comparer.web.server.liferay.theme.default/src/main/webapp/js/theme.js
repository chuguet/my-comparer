var session;
var closeSession;
var signin = '$sign_in_url';

function showAlert() {
	open_active_dialog();
	var time;
	var isSignedIn = '$is_signed_in';
	if (isSignedIn == 'true') {
		time = 120000;
	} else {
		time = 60000;
	}
	closeSession = setTimeout(function() {
		closeSessionEvent()
	}, time);
}

function sessionCount() {
	var time;
	var isSignedIn = '$is_signed_in';
	var path = window.location.pathname;
	var surebetPage = 'apuestas-seguras';
	var valuebetPage = 'value-bets';
	if (isSignedIn == 'true') {
		if ((path.indexOf(surebetPage) != -1)
				|| (path.indexOf(valuebetPage) != -1)) {
			time = 3600000;
		} else {
			time = 480000;
		}
	} else {
		time = 360000;
	}
	session = setTimeout(function() {
		showAlert()
	}, time);
}

function resetCount() {
	clearTimeout(session);
	sessionCount();
}

function ajaxCloseSession() {
	var signOuturl = '$sign_out_url';
	jQuery.ajax({
		type : "POST",
		url : signOuturl,
		error : function() {
			alert("No se ha podido cerrar la sesion");
		},
		success : function() {
			open_close_session_dialog();
		}
	});
}

function closeSessionEvent() {
	fire('expireSessionEvent', '', '', '');
	var isSignedIn = '$is_signed_in';
	if (isSignedIn == 'true') {
		ajaxCloseSession();
	}
}

function active() {
	clearTimeout(closeSession);
	sessionCount();
}

var _actualView = window.location.hash;

function OnHashChange(event) {

	var isPageToReset = pathProcess();

	if (isPageToReset == true) {
		resetCount();
	}

	var hashView = window.location.hash;

	if ((hashView != _actualView)) {
		hashProcess();
	}
}

function dialog(id, dheight, dwidth, dtitle) {
	$(id).dialog({
		modal : true,
		title : dtitle,
		height : dheight,
		width : dwidth,
	});
}

function open_active_dialog() {
	$("#dialog-active").dialog({
		modal : true,
		dialogClass : "no-close",
		height : 200,
		width : 400,
		buttons : [ {
			text : "Continuar conectado",
			click : function() {
				$(this).dialog("close");
				active();
			}
		} ]
	});
}
function open_close_session_dialog() {

	$("#dialog-active").dialog("close");
	$("#dialog-close-session").dialog({
		dialogClass : "no-close",
		modal : true,
		height : 200,
		width : 400,
		buttons : [ {
			text : "Acceder",
			click : function() {
				$(this).dialog("close");
				window.location = window.location.origin + "/c/portal/login";

			}
		} ]
	});

}

function clearTimeouts() {
	clearTimeout(session);
	clearTimeout(closeSession);
}

function pathProcess() {
	var path = window.location.pathname;
	var initPage = 'inicio';
	var surebetPage = 'apuestas-seguras';
	var valuebetPage = 'value-bets';
	var maximizedState = 'maximized';

	if ((path.indexOf(initPage) != -1) || (path.indexOf(surebetPage) != -1)
			|| (path.indexOf(valuebetPage) != -1)) {
		return true;
	}
}

$(document).ready(function() {
	var isPageToReset = pathProcess();
	if (isPageToReset == true) {
		sessionCount();
		load();
	}
});
