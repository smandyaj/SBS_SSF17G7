/**
 * 
 */

function validateUserForm() {
			var fName = document.forms["registerPage"]["first_name"].value;
			if (fName == null || fName == "") {
				alert("Enter First Name");
				return false;
			}

			var lName = document.forms["registerPage"]["last_name"].value;
			if (lName == null || lName == "") {
				alert("Enter Last Name");
				return false;

			}

			var emailId = document.forms["registerPage"]["email_id"].value;
			if (emailId == null || emailId == "") {
				alert("Please enter Email Id");
				return false;
			} else {
				var mailformat = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				if (emailId.match(mailformat)) {
					document.registerPage.email_id.focus();
				} else {
					alert("You have entered an invalid email address!");
					document.registerPage.email_id.focus();
					return false;
				}
			}

			var userPass = document.forms["registerPage"]["password"].value;
			if (userPass == null || userPass == "") {
				alert("Please enter your password");
				return false;
			}
			var confirmPass = document.forms["registerPage"]["confirmPassword"].value;
			if (confirmPass == null || confirmPass == "") {
				alert("Please confirm password");
				return false;
			}
			if (userPass != confirmPass) {
				alert("Passwords do not match");
				return false;
			}
			
			var phoneNum = document.forms["registerPage"]["phone"].value;
			if (phoneNum == null || phoneNum == "") {
				alert("please Phone Number");
				return false;
			}

			var customerAddress = document.forms["registerPage"]["customer_address"].value;
			if (customerAddress == null || customerAddress == "") {
				alert("please Enter Address");
				return false;
			}


			var state = document.forms["registerPage"]["state"].value;
			if (state == null || state == "") {
				alert("please Enter State");
				return false;

			}
			
			var country = document.forms["registerPage"]["country"].value;
			if (country == null || country == "") {
				alert("please Enter Country");
				return false;

			}

			var zip = document.forms["registerPage"]["zip"].value;
			if (zip == null || zip == "") {
				alert("please Enter Zipcode");
				return false;

			}
			if (isNaN(j) || j.indexOf(" ") != -1) {
				alert("Enter numeric value");
				return false;
			}
			if (zip.length > 5) {
				alert("Invalid Pin. Enter Again");
				return false;
			}

			return true;
		}