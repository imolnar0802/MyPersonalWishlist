$( document ).ready(function(){
	var field = document.getElementById("pass");
	var letter = document.getElementById("letter");
	var capital = document.getElementById("capital");
	var number = document.getElementById("number");
	var length = document.getElementById("length");
	
	field.onfocus = function() {
	  document.getElementById("message").style.display = "block";
	}
	
	// When the user clicks outside of the password field, hide the message box
	field.onblur = function() {
	  document.getElementById("message").style.display = "none";
	}
	
	field.onkeyup = function() {
		var lowerCaseLetters = /[a-z]/g;
		var upperCaseLetters = /[A-Z]/g;
		var numbers = /[0-9]/g;
		
		if(field.value.match(lowerCaseLetters)) {
			letter.style.color = "green";
		} else {
			letter.style.color = "red";
		}
		
		if(field.value.match(upperCaseLetters)) {
		    capital.style.color = "green";
		} else {
		    capital.style.color = "red";
		}
		
		if(field.value.match(numbers)) {
		    number.style.color = "green";
		} else {
		    number.style.color = "red";
		}
		
		if(field.value.length >= 8) {
		    length.style.color = "green";
		} else {
		    length.style.color = "red";
		}
	}
});