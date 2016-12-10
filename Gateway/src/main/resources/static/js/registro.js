var AvatarSeleccionado=0;
var url = ["f1","f2","f3","m1","m2","m3"];

function changeAvatar(accion){
	var urlImagen;
	
	if(accion.getAttribute("id")=="Anterior"){
		urlImagen = anterior();
	}
	if(accion.getAttribute("id")=="Siguiente"){
		urlImagen = siguiente();
	}
	


	document.getElementById("avatar").setAttribute("src","images/"+urlImagen+".png");
	document.getElementById("avatar").setAttribute("th:ref","@{images/"+urlImagen+".png");
	document.getElementById("avatarName").setAttribute("value", urlImagen+".png");
}

function siguiente(){
	AvatarSeleccionado= AvatarSeleccionado +1;
	if(AvatarSeleccionado>=0 && AvatarSeleccionado<=5){
		return url[AvatarSeleccionado];

	}
	else{
		
		AvatarSeleccionado =0;
		return "f1";
	}
}

function anterior(){
	AvatarSeleccionado= AvatarSeleccionado -1;
	if(AvatarSeleccionado>=0 && AvatarSeleccionado<=5){
		return url[AvatarSeleccionado];

	}
	else{
		
		AvatarSeleccionado =5;
		return "m3";
	}
}