<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />

<h1>PRUEBAS PASARELA DE PAGOS</h1>
<style>
#selectable1 .ui-selecting,#selectable2 .ui-selecting,#selectable3 .ui-selecting
	{
	background: #FECA40;
}

#selectable1 .ui-selected,#selectable2 .ui-selected,#selectable3 .ui-selected
	{
	background: #F39814;
	color: white;
}

#selectable1,#selectable2,#selectable3 {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 450px;
}

#selectable1 li,#selectable2 li,#selectable3 li {
	margin: 3px;
	padding: 1px;
	float: left;
	width: 100px;
	height: 80px;
	font-size: 21px;
	text-align: center;
}
</style>
<script>
	

	$(function() {
    	$( "#selectable1" ).selectable({
     	 stop: function() {
      	  var result = $( "#select-result" ).empty();
       	 $( ".ui-selected", this ).each(function() {
       	   var index = $( "#selectable1 li" ).index( this );
        	  result.append( ( index + 1 ) );
      	  });
     	 }
   	 });
 	 });
	$(function() {
    	$( "#selectable2" ).selectable({
     	 stop: function() {
      	  var result = $( "#select-result" ).empty();
       	 $( ".ui-selected", this ).each(function() {
       	   var index = $( "#selectable2 li" ).index( this );
        	  result.append( ( index + 4 ) );
      	  });
     	 }
   	 });
 	 });
	$(function() {
    	$( "#selectable3" ).selectable({
     	 stop: function() {
      	  var result = $( "#select-result" ).empty();
       	 $( ".ui-selected", this ).each(function() {
       	   var index = $( "#selectable3 li" ).index( this );
        	  result.append( ( index + 7 ) );
      	  });
     	 }
   	 });
 	 });
	
</script>
<script>
	$(function() {
		var icons = {
			header : "ui-icon-circle-arrow-e",
			activeHeader : "ui-icon-circle-arrow-s"
		};
		$("#accordion").accordion({
			icons : icons
		});
		$("#toggle").button().click(function() {
			if ($("#accordion").accordion("option", "icons")) {
				$("#accordion").accordion("option", "icons", null);
			} else {
				$("#accordion").accordion("option", "icons", icons);
			}
		});
	});
</script>
<script>

	
  $(function() {
    $( "button" )
      .button()
      .click(function() {
    	  
    	  var isSignedIn = '<%= themeDisplay.isSignedIn() %>';
    	  
    	  if(isSignedIn == 'false'){
    		  alert("No estas registrado, registrate primero.");
    		  window.location = '/inicio?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Fcreate_account';
    		  return;
    	  }
    	 
    	  
    	  $( "#progressbar" ).progressbar({
    	      value: false
    	    });
    	  
    	  $.ajax({
    	      type: 'POST',
    	      contentType: "application/json",
    	      data: $( "#select-result" ).text(),
    	      success: function(data) { 
    	    	  if(data['status']=='OK'){
    	    		  window.location = data['value'];
    	    	  }else{
    	    		  alert('Se ha producido un error, no se puede realizar el pago.');
    	    	  }
    	      },
    	      error: function(data){ alert('Se ha producido un error, no se puede realizar el pago.'); },
    	      url: '/com.comparadorad.bet.comparer.web.server.portlet.payment/PaymentModule/rest/paymentController/getToken',
    	      cache:false
    	    });
      });
  });
  </script>

<div id="accordion">
	<h3>Servicio Premium</h3>
	<div>
		<ol id="selectable1">
			<li class="ui-state-default">30 días 99E</li>
			<li class="ui-state-default">90 días 249E</li>
			<li class="ui-state-default">365 días 949E</li>
		</ol>
	</div>
	<h3>Servicio Profesional</h3>
	<div>
		<div>
			<ol id="selectable2">
				<li class="ui-state-default">30 días 39E</li>
				<li class="ui-state-default">90 días 99E</li>
				<li class="ui-state-default">365 días 374E</li>
			</ol>
		</div>
	</div>
	<h3>Servicio Básico</h3>
	<div>
		<div>
			<ol id="selectable3">
				<li class="ui-state-default">30 días 6E</li>
				<li class="ui-state-default">90 días 15E</li>
				<li class="ui-state-default">365 días 57E</li>
			</ol>
		</div>
	</div>
</div>
<div id="progressbar"></div>
<br>
<button>Pagar con PayPal</button>

<span id="select-result"></span>.
