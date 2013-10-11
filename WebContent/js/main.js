$(document).ready(function(){
	/* Definición del tamaño de la imagen en las páginas de registro */
	regImgHeight();
	function regImgHeight(){
	var height = $(".know-height").css("height");
	$(".img-reg").css("height", parseInt(height));
	console.log(height);

	
	
};

/*funciones al cambiar el tamaño de la ventana de navegador*/
$(window).resize(function(){
		regImgHeight();
		//obtainMargin();
	});

/*Agregar Links de forma dinámica*/
	var contadorLinks = 0;
	/* Se debe agregar que solo se ponga un nuevo link, si es una url válida. No sé hacer esto */
	$(".link-btn").click(function(){
		if(contadorLinks<4){
		$(".last-link").addClass("early-link").removeClass("last-link");
		$(".early-link").after("<input type='text' class='form-control margined-top nombre-link' placeholder='Nombre del link Ej: Facebook'><input type='text' class='form-control links last-link profile-link' placeholder='Ingresa un Link'>").removeClass("early-link");
		regImgHeight();
	}
	else{

		$(".link-alert").fadeIn("fast", "linear");
		$(this).attr("disabled", "disabled");
	}
	contadorLinks ++;
	console.log(contadorLinks);
	});

/* tooltips */

$('#finish-trueque').tooltip({placement: "top"});
$("#one-star").tooltip({placement: "top"});
$("#two-star").tooltip({placement: "top"});
$("#three-star").tooltip({placement: "top"});
$("#four-star").tooltip({placement: "top"});
$("#five-star").tooltip({placement: "top"});

/* Agregar y Borrar Necesitos a proyectos de forma dinámica */

$(".necesito-btn").click(function(){
		var valor = $(".last-necesito").val();
		console.log(valor);
		$(".last-necesito").addClass("early-necesito").removeClass("last-link");
		$(".desc-last-necesito").addClass("desc-early-necesito").removeClass("desc-last-necesito");
		$(".early-necesito").after("<input type='text' class='form-control necesito last-necesito' placeholder='Nombre del Necesito'><label for='categoria-necesito' class='white desc-last-necesito'>¿En qué categoría lo pondrías?</label><select id='categoria-necesito' class='form-control desc-last-necesito'><option value='1'>categoria_1</option><option value='2'>categoria_2</option><option value='3'>categoria_3</option></select><p class='white margined-top desc-last-necesito'><strong>Descripción del Necesito </strong><small class='white'>(Máximo 140 caracteres)</small></p><textarea class='form-control gap desc-last-necesito' rows='2'></textarea>").removeClass("early-link");
		$(".early-necesito").after("<p class=white>"+ valor + "<span class='close-necesito right white white-link'>X</span></p>");
		$(".desc-early-necesito").detach();
		$(".early-necesito").detach();
		regImgHeight();
	$(".close-necesito").on("click", function(){
		$(this).parent().detach();
});
	});

/* Diálogos de agregar tengos e invitar usuarios */
/*
$(".add-tengos").click(function(){
	vex.dialog.alert("espacio para diálogo de agregar tengos");
});

$(".add-usuarios").click(function(){
	vex.dialog.alert("espacio para diálogo de invitar usuarios");
});
*/

/*díalogo de login*/
/*
	$(".log-omega").click(function(){
		vex.dialog.buttons.YES.text="Ingresar"
		vex.dialog.buttons.NO.text = 'Atras'
		vex.dialog.open({message: "Ingresa tu correo electrónico y contraseña", 
			input: "<input name='usuario' type='email' placeholder='Correo Electrónico' required /><input name='password' type='password' placeholder='Contraseña' required />", 
			buttons: [$.extend({}, vex.dialog.buttons.YES), $.extend({}, vex.dialog.buttons.NO)], 
			callback: function(value){
				if(value==false){
					return console.log("Cancelled");
				}else{
					console.log("Username: " + value.usuario + " password: " + value.password);
				}
			}});
	});
*/
	/* Diálogo de Contacto */
/*
$(".contact").click(function(e){
	e.preventDefault();
		vex.dialog.buttons.YES.text="Enviar"
		vex.dialog.buttons.NO.text = 'Cancelar'
		vex.dialog.open({message: "Ingresa los siguientes datos y tu mensaje", 
			input: "<input name='correo' type='email' placeholder='Correo Electrónico' required /><input name='nombre' type='text' placeholder='Nombre y Apellido' required /><p>Tú Mensaje</p><textarea name='contacto' class='gap' rows='6'></textarea>", 
			buttons: [$.extend({}, vex.dialog.buttons.YES), $.extend({}, vex.dialog.buttons.NO)], 
			callback: function(value){
				if(value==false){
					return console.log("Cancelled");
				}else{
					console.log("Username: " + value.usuario + " password: " + value.password);
				}
			}});
	});
*/

	/* Expansión de Tengos */

	$(".tengo-btn").click(function(){
		console.log("asdf");
		$(this).parent().children(".caption").fadeToggle("fast", "linear");
		$(this).parent().children("img").fadeToggle("fast", "linear");
	})
/* Obtener márgenes para objetos del perfil */
	/*function obtainMargin(){
		var margen = (parseInt($(".pic").css("height")) - parseInt($(".menu").css("height")))/2;
		
		$(".nav-profile").css("margin-top", parseInt(margen));
		console.log($(".nav-profile").css("margin-top"));
		$(".menu").css("margin-top", parseInt($(".pic").css("height"))/4)
	};*/

// dinamización de la búsqueda
function checkStatus(){
	var valueP = $(".people-check").prop("checked");
	var valueT = $(".tengo-check").prop("checked");
	var valueN = $(".necesito-check").prop("checked");
	var valuePr = $(".project-check").prop("checked");
	if(valueP ==false){
		$(".people-search").addClass("not");
	}
	if(valueT == false){
	$(".tengo-sub").attr("style", "display:none");
	$(".tengo-search").addClass("not");
}
if(valueN ==false){
	$(".necesito-sub").attr("style", "display:none");
	$(".necesito-search").addClass("not")
}
if(valuePr == false){
	$(".project-search").addClass("not");
}
}; 

checkStatus();
$(".people-check").click(function(){

	$(".people-search").fadeToggle("fast", "linear");
	var value = $(".people-search").css("opacity");
	/*if($(".people-search").css("opacity") == "1"){
		console.log("no está");
		$(".tengo-search").removeClass("col-md-3 col-sm-3 col-lg-3").addClass("col-md-5 col-sm-5 col-lg-5");
		$(".necesito-search").removeClass("col-md-3 col-sm-3 col-lg-3").addClass("col-md-5 col-sm-4 col-lg-5");
		$(".people-search").addClass("hidden-xs hidden-sm hidden-md hidden-lg");
	}else{
		$(".tengo-search").addClass("col-md-3 col-sm-3 col-lg-3").removeClass("col-md-5 col-sm-5 col-lg-5");
		$(".necesito-search").addClass("col-md-3 col-sm-3 col-lg-3").removeClass("col-md-5 col-sm-4 col-lg-5");
		$(".people-search").removeClass("hidden-xs hidden-sm hidden-md hidden-lg");
		console.log("si está");
	}*/

});


$(".tengo-check").click(function(){
	$(".tengo-search").fadeToggle("fast", "linear");
	$(".tengo-sub").fadeToggle("fast", "linear");
});

$(".necesito-check").click(function(){
	$(".necesito-search").fadeToggle("fast", "linear");
	$(".necesito-sub").fadeToggle("fast", "linear");
});
$(".project-check").click(function(){
	$(".project-search").fadeToggle("fast", "linear");
});

/* Responder a comentarios */

$(".reply").click(function(e){
	e.preventDefault();
	$(this).parent().children(".reply-area").fadeIn("50", "linear");
});
$(".reply-sub").click(function(){
	$(this).parent().fadeOut("50", "linear");
});

/* diálogo clasificación */

	var oneClick;
	var twoClick;
	var threeClick;
	var fourClick;
	var fiveClick;
	var value;


function starColors(){
	


$("#one-star").click(function(){
	if(twoClick == false && threeClick == false && fourClick == false && fiveClick ==false){
	oneClick = !oneClick;
	if($(this).hasClass("yellow")){
		$(this).removeClass("yellow");
		value = 0;
	}else{
	$(this).addClass("yellow");
	value = 1;

}	
}else{
	oneClick = true;
	twoClick = false;
	threeClick = false;
	fourClick = false;
	fiveClick = false;
	$("#two-star").removeClass("yellow");
	$("#three-star").removeClass("yellow");
	$("#four-star").removeClass("yellow");
	$("#five-star").removeClass("yellow");
	value = 1;
}
});

$("#two-star").mouseenter(function(){
	$("#one-star").addClass("yellow");
});
$("#two-star").click(function(){
	if(threeClick == false && fourClick == false && fiveClick ==false){
	twoClick = !twoClick;
	if($(this).hasClass("yellow")){
		$(this).removeClass("yellow");
		value = 0;
		oneClick = false;
	}else{
	$(this).addClass("yellow");
	value = 2;
	oneClick = true;
}	
}else{

	twoClick = true;
	oneClick = true;
	threeClick = false;
	fourClick = false;
	fiveClick = false;
	$("#three-star").removeClass("yellow");
	$("#four-star").removeClass("yellow");
	$("#five-star").removeClass("yellow");
	value = 2;
}

	
});

$("#two-star").mouseleave(function(){
	if(twoClick ==false || twoClick == undefined){
		if(oneClick ==false || oneClick == undefined){
	$("#one-star").removeClass("yellow");
};
}else{

};
});


$("#three-star").mouseenter(function(){
	$("#one-star").addClass("yellow");
	$("#two-star").addClass("yellow");
});
$("#three-star").click(function(){
	if(fourClick == false && fiveClick ==false){
	threeClick = !threeClick;
	if($(this).hasClass("yellow")){
		$(this).removeClass("yellow");
		value = 0;
		twoClick = false;
		oneClick = false;
	}else{
	$(this).addClass("yellow");
	value = 3;
	twoClick = true;
	oneClick = true;
}	
}else{
	console.log("asdf");
	threeClick = true;
	twoClick = true;
	oneClick = true;
	fourClick = false;
	fiveClick = false;

	$("#four-star").removeClass("yellow");
	$("#five-star").removeClass("yellow");
	value = 3;
}

	
});

$("#three-star").mouseleave(function(){
	if(threeClick ==false || threeClick == undefined){
		if(oneClick == false || oneClick == undefined){
	$("#one-star").removeClass("yellow");
}
if(twoClick == false || twoClick == undefined){
	$("#two-star").removeClass("yellow");
}

}else{

}
});


$("#four-star").mouseenter(function(){
	$("#one-star").addClass("yellow");
	$("#two-star").addClass("yellow");
	$("#three-star").addClass("yellow");
});
$("#four-star").click(function(){
	if(fiveClick ==false){
	fourClick = !fourClick;
	if($(this).hasClass("yellow")){
		$(this).removeClass("yellow");
		value = 0;

		threeClick = false;
		twoClick = false;
		oneClick = false;
	}else{
	$(this).addClass("yellow");
	value = 4;
	threeClick = true;
	twoClick = true;
	oneClick = true;
}	
}else{

	fourClick = true;
	threeClick = true;
	twoClick = true;
	oneClick = true;
	fiveClick = false;


	$("#five-star").removeClass("yellow");
	value = 4;
}

	
});

$("#four-star").mouseleave(function(){
	if(fourClick ==false || fourClick == undefined){
		if(oneClick==false || oneClick == undefined){
	$("#one-star").removeClass("yellow");
}
if(twoClick==false || twoClick == undefined){
	$("#two-star").removeClass("yellow");
}
if(threeClick==false || threeClick == undefined){
	$("#three-star").removeClass("yellow");
}
}else{

}
});


$("#five-star").mouseenter(function(){
	$("#one-star").addClass("yellow");
	$("#two-star").addClass("yellow");
	$("#three-star").addClass("yellow");
	$("#four-star").addClass("yellow");
});

$("#five-star").click(function(){
	fiveClick = !fiveClick;
	if(fiveClick ==true){
		value = 5;
		$(this).addClass("yellow");
		fourClick = true;
		threeClick = true;
		twoClick = true;
		oneClick = true;
	}else{
		value= 0;
		$(this).removeClass("yellow");
		fourClick = false;
		threeClick = false;
		twoClick = false;
		oneClick = false;
	}
});

$("#five-star").mouseleave(function(){
	if(fiveClick ==false || fiveClick == undefined){
		if(oneClick == false || oneClick == undefined){
	$("#one-star").removeClass("yellow");
	
}
if(twoClick == false || twoClick == undefined){
	$("#two-star").removeClass("yellow");
}
if(threeClick == false || threeClick == undefined){
	$("#three-star").removeClass("yellow");
	}
	if(fourClick == false || fourClick == undefined){
	$("#four-star").removeClass("yellow");
}

}else{

}
});







};
starColors();
modalTruequeNecesito();

/* Modal Trueque Registro */

function modalTruequeNecesito(){
	var necesito;
	var value;
	var otro;
	var extra;
	var mensaje;

	$(".necesito-trocar").click(function(){
		necesito = $(this).parent().parent().parent().children("h3").text();

	});
	$("#tengo-proyecto").click(function(){
		value = $(this).val();
	if(value == "otro"){

		$("#otro-proyecto-tengo").removeAttr("disabled");
	}else{
		$("#otro-proyecto-tengo").attr("disabled", "disabled").val("");
	};

	});

	$(".preview-trueque-necesito").click(function(){
		$(this).popover("destroy");
		otro = $("#otro-proyecto-tengo").val();
		extra = $(".extra-necesito").val();
		if($("#otro-proyecto-tengo").val()!= ""){
		
		mensaje = "Veo que necesitan "+necesito+". Yo lo tengo y a cambio les pido "+otro+". "+extra;
		}else{
			mensaje = "Veo que necesitan "+necesito+". Yo lo tengo y a cambio les pido "+value+". "+extra;
		}
$(".preview-trueque-necesito").popover({
		placement: "top",
		trigger: "manual",
		title: "Propuesta de Trueque",
		content: mensaje
	});
		$(this).popover('show');

console.log(mensaje);
	});
	$(".close-trueque-necesito").click(function(){
		$(".preview-trueque-necesito").popover('hide');
	})
}

/*Modal Trueque Tengo*/

function modalTruequeNecesito(){
	var tengo;
	var value;
	var otro;
	var extra;
	var mensaje;

	$(".tengo-trocar").click(function(){
		tengo = $(this).parent().parent().parent().children("h3").text();

	});
	$("#necesito-proyecto").click(function(){
		value = $(this).val();
	if(value == "otro"){

		$("#otro-proyecto-necesito").removeAttr("disabled");
	}else{
		$("#otro-proyecto-necesito").attr("disabled", "disabled").val("");
	};

	});

	$(".preview-trueque-tengo").click(function(){
		$(this).popover("destroy");
		otro = $("#otro-proyecto-necesito").val();
		extra = $(".extra-tengo").val();
		if($("#otro-proyecto-necesito").val()!= ""){
		
		mensaje = "Yo necesito "+tengo+". A cambio te puedo ofrecer "+otro+". "+extra;
		}else{
			mensaje = "Yo necesito "+tengo+". A cambio te puedo ofrecer "+value+". "+extra;
		}
$(".preview-trueque-tengo").popover({
		placement: "top",
		trigger: "manual",
		title: "Propuesta de Trueque",
		content: mensaje
	});
		$(this).popover('show');

console.log(mensaje);
	});
	$(".close-trueque-tengo").click(function(){
		$(".preview-trueque-tengo").popover('hide');
	})
}

/* Notificaciones */

$("#notif").click(function(){
	$("#body-notif").fadeToggle("0", "linear");
})

});