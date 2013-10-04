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

		vex.dialog.alert("No se pueden tener más de 5 links")
	}
	contadorLinks ++;
	console.log(contadorLinks);
	});

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

$(".add-tengos").click(function(){
	vex.dialog.alert("espacio para diálogo de agregar tengos");
});

$(".add-usuarios").click(function(){
	vex.dialog.alert("espacio para diálogo de invitar usuarios");
});

/*díalogo de login*/

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

	/* Diálogo de Contacto */

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

});