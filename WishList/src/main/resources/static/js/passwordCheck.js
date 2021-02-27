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
			$("letter").removeClass("fas fa-minus-circle");
		    $("letter").addClass("fas fa-check-circle");
		} else {
			$("letter").removeClass("fas fa-check-circle");
			$("letter").addClass("fas fa-minus-circle");
		}
		
		if(field.value.match(upperCaseLetters)) {
		    capital.classList.remove("invalid");
		    capital.classList.add("valid");
		} else {
		    capital.classList.remove("valid");
		    capital.classList.add("invalid");
		}
		
		if(field.value.match(numbers)) {
		    number.classList.remove("invalid");
		    number.classList.add("valid");
		} else {
		    number.classList.remove("valid");
		    number.classList.add("invalid");
		}
		
		if(field.value.length >= 8) {
		    length.classList.remove("invalid");
		    length.classList.add("valid");
		} else {
		    length.classList.remove("valid");
		    length.classList.add("invalid");
		}
	}
});