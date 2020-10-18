/*
Once Document is Ready to Performed, take the following actions
*/
$(document).ready(function() {
	checkPath();
    $('a').click(function (e){
		pathname = window.location.pathname;
		checkURL(pathname);
	});
});

function checkPath(pathname){
	if(!pathname) pathname = window.location.pathname;
	    console.log(window.location.pathname);
	
		if (pathname == "/abcjobs/register")
	{
		registerValidation();
	}
	
		else if (pathname == "/abcjobs/login")
	{
		loginValidation();
	}
	
	
		else if (pathname == "/abcjobs/users")
	{
		searchUsersValidation();
	}
	
		else if (pathname == "/abcjobs/jobs")
	{
		searchJobsValidation();
	}
	
		else if (pathname == "/abcjobs/profile-update")
	{
		updateProfileValidation();
	}
	
		else if (pathname == "/abcjobs/forget-password")
	{
		forgetPasswordValidation();
	}
	
		else if (pathname == "/abcjobs/reset-password")
	{
		resetPasswordValidation();
	}
	
	
};


/*
Form VALIDATION 

Table Of Contents:

01. Check Blank
02. Print Blank Error Message
03  Check for Alpha Character
04  Print Alpha Error Message
05  Check for Numeric Character
06  Print Numeric Error Message
07  Check for email validity 
08  Print Email Error Message 
09  Check for Phone Length
10  Print Phone Length Error Message 
11  Check for Password Length 
12. Print Password Length Error Messsage
13. Print Random Message
14. Validation [Validate when an event fire || onSubmit ] 
*/


// 1. C H E C K  I F  F I E L D  I S  B L A N K
function checkBlank (eID)
{
	var value = document.getElementById(eID).value;
	if (value.trim() == '')
	{
	return true;
	}
	else
	{
	return false;
	}
}

// 2. Print Blank Error Msg
function blankErrorMsg (eID, errID)
{
    if(checkBlank(eID))
	randomeErrorMsg(errID,'Please fill in this fill');
    else
	randomeErrorMsg(errID,'');
}

// 3. C H E C K  I F  F I E L D  H A S  A L P H A B E T  F O R  E V E N T
// IF is not equal to [ (A-Z) || (Num-Lock Keys) || (No key entered) || (backspace/delete) || (spacebar)]
function checkalpha (event)
{
if(!( (event.which >= 65 && event.which <= 90) || (event.which >= 97 && event.which <= 122) ||
(event.which == 0) || (event.which == 8) || (event.which == 32)))
{
	event.preventDefault();
    return false;
}
else
	return true;
}

// 4. Print Alpha Error message
function alphaErrorMsg (errID){
	randomeErrorMsg(errID,"Invalid Name Format. Please enter only alphabet.");
}


// 5. C H E C K  I F  F I E L D  H A S  N U M B E R  F O R  E V E N T
// IF is not equal to (0-9)
function checkNum (event)
{
if(!( (event.which >= 48 && event.which <= 57) || (event.which == 8) ))
	{
		event.preventDefault();
		return false;
	}
	else
		return true;
}

// 6. Print Numeric Error Message
function numErrorMsg(errID)
{
	randomeErrorMsg(errID,"Invalid Number Format. Please enter only number.");
}


/*
7. EMAIL VALIDATION
*/
// Validate email based on pattern : Must be in the form of 'xxx@xxx.xxx or xxx@xxx.xx'
function checkEmail (eID)
{
    var value = document.getElementById(eID).value;
        
    if ((/^\w+([\.-]?\w+)+@\w+\.\w{2,3}(\.\w{2})?$/g).test(value))
    return true
    else
        return false;
}

// 8. Print Email Error Message Must be in the form of 'xxx@xxx.xxx or xxx@xxx.xx'
function emailPrintMsg (errID)
{    
	randomeErrorMsg(errID,"Email must be valid form. xxx@xxxxx.xxx or xxx@xxxxx.xxx.xx");
}


// 9. C  H  E  C  K  T H E  L E N G T H  O F  P H O N E  N U M B E R 
function checkPhoneLength(eID){
    var value = document.getElementById(eID).value;

    if ((/^\d{10,11}$/g).test(value))
        return true;
    else
        return false;
}

// 10. Print Error Message for Phone Length
function phoneLengthErrorMsg(errID){
	randomeErrorMsg(errID,"Please enter minimum 10 digits maximum 11 digits.");
}


// 11. C  H  E  C  K  T H E  L E N G T H  O F  P A S S W O R D
function checkPasswordLength(eID){
    var value = document.getElementById(eID).value;
    // at least 1 number, 1 lowercase and 1 uppercase letter
    // Must be 12 characters.
    if ((/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{16}$/g).test(value))
        return true;
    else
        return false;
}

// 12. Print Error Message for Phone Length
function passwordLengthErrorMsg(errID){
	//document.getElementById(errID).innerHTML = "Please enter 16 characters.";
	randomeErrorMsg(errID,"Please enter 16 characters. At least 1 number, 1 lowercase and 1 uppercase letter");

}

// 13. Check if the value of password = confirmed password
function checkConfirmedPassword(eID1, eID2){
	var cnfPassword = document.getElementById(eID1).value;
	var password = document.getElementById(eID2).value;
	
	if (cnfPassword == password) return true;
	
	return false;
}

// 14. Print Random Message
function randomeErrorMsg(errID,msg){
	document.getElementById(errID).innerHTML = msg;
}


/* 
	Register Validation
*/
function registerValidation(){
	var fname= 'fname';
	var lname= 'lname';
	var email= 'email';
	var password= 'password';
	var confirmedPassword = "confirmed-password";

	var errorFName = 'error-fname';
	var errorLName= 'error-lname';
	var errorPhone= 'error-phone';
	var errorEmail= 'error-email';
	var errorPassword= 'error-password';
	var errorCnfPassword='error-confirmed-password';
	

	var dataString = "";
	

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/

	$( '#password' ).keydown(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});

	$( '#password' ).keyup(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});
	
	$( '#confirmed-password' ).keydown(function() {
		if (!checkPasswordLength(confirmedPassword)){
			passwordLengthErrorMsg(errorCnfPassword);
		}else{
			randomeErrorMsg(errorCnfPassword,"");
		}
	});

	$( '#confirmed-password' ).keyup(function() {
		if (!checkPasswordLength(confirmedPassword)){
			passwordLengthErrorMsg(errorCnfPassword);
		}else{
			randomeErrorMsg(errorCnfPassword,"");
		}
	});
	

	$( '#email' ).keydown(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#email' ).keyup(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#fname' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorFName);
		}else{
			randomeErrorMsg(errorFName,"");
		}
	});

	$( '#lname' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorLName);
		}else{
			randomeErrorMsg(errorLName,"");
		}
	});


		/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(event){

        if(checkBlank(fname) || checkBlank(lname) || checkBlank(email) || checkBlank(password) || checkBlank(confirmedPassword)
        || !checkConfirmedPassword(confirmedPassword,password))
        {
        	event.preventDefault();
            blankErrorMsg(fname,errorFName);
            blankErrorMsg(lname,errorLName);
            blankErrorMsg(email,errorEmail);
            blankErrorMsg(password,errorPassword);
            blankErrorMsg(confirmedPassword,errorCnfPassword);

            if(!checkEmail(email)){
                emailPrintMsg(errorEmail);
                event.preventDefault();
            }

            if (!checkPasswordLength(password)){
                passwordLengthErrorMsg(errorPassword);
                event.preventDefault();
            }
            
            if (!checkPasswordLength(confirmedPassword)){
                passwordLengthErrorMsg(errorCnfPassword);
                event.preventDefault();
            }
            
            if(!checkConfirmedPassword(confirmedPassword,password)){
            	randomeErrorMsg(errorCnfPassword,"Password must match Confirmed Password!");
            	event.preventDefault();
            }

		}
		else{
		window.location.replace('thankyou');
		}
		
	}); // End of Validation for register
};
	
	
	
/* 
	Login Validation
*/
function loginValidation(){
	var email= 'email';
	var password= 'password';

	var errorEmail= 'error-email';
	var errorPassword= 'error-password';	

	var dataString = "";
	

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/

	$( '#password' ).keydown(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});

	$( '#password' ).keyup(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});
	

	$( '#email' ).keydown(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#email' ).keyup(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});


	/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(){


        if(checkBlank(email) || checkBlank(password))
        {
            blankErrorMsg(email,errorEmail);
            blankErrorMsg(password,errorPassword);

            if(!checkEmail(email)){
                emailPrintMsg(errorEmail);
                event.preventDefault();
            }

            if (!checkPasswordLength(password)){
                passwordLengthErrorMsg(errorPassword);
                event.preventDefault();
            }

		}
		
		// Perform the following when the above VALIDATIONS are PASSED.
        else
        {

			window.location.replace('home');
        }
	}); // End of Validation for login
};




/* 
	Search users Validation
*/
function searchUsersValidation(){
	var searchUsers= 'searchUsers';

	var errorSearchUsers= 'error-searchUsers';	

	var dataString = "";
	

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/
	
	
	$( '#searchUsers' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorSearchUsers);
		}else{
			randomeErrorMsg(errorSearchUsers,"");
		}
	});


	/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(){

        if(checkBlank(searchUsers))
        {
            blankErrorMsg(searchUsers,errorSearchUsers);
		}
		
		// Perform the following when the above VALIDATIONS are PASSED.
        else
        {

			var searchUsersVal=$("#searchUsers").val();
			dataString = 'searchUsers=' + searchUsersVal;
            $.ajax({
            type:"POST",
            url:"./users-search-results",
            data:dataString,
            cache:false
        });
    }
    	return false;
	}); // End of Validation for Search users results
};



/* 
	Search jobs Validation
*/
function searchJobsValidation(){
	var searchJobs= 'searchJobs';

	var errorSearchJobs= 'error-searchJobs';	

	var dataString = "";
	

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/
	
	
	$( '#searchJobs' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorSearchJobs);
		}else{
			randomeErrorMsg(errorSearchJobs,"");
		}
	});


	/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(){

        if(checkBlank(searchJobs))
        {
            blankErrorMsg(searchJobs,errorSearchJobs);
		}
		
		// Perform the following when the above VALIDATIONS are PASSED.
        else
        {

			var searchUsersVal=$("#searchUsers").val();
			dataString = 'searchUsers=' + searchUsersVal;
            $.ajax({
            type:"POST",
            url:"./users-search-results",
            data:dataString,
            cache:false
        	});
    	}
    	return false;
	}); // End of Validation for Search jobs results
};
	
	
/* 
	Update Profile Validation
*/
function updateProfileValidation(){
	var fname= 'fname';
	var lname= 'lname';
	var email= 'email';
	var password= 'password';
	var currentJob = "current-job";
	var currentCompany = "current-company";
	var contactNo = "contactno";
	var biography = "biography";
	var city = "city";
	var country = "country";
	var skills = "skills";

	var errorFName = 'error-fname';
	var errorLName= 'error-lname';
	var errorEmail= 'error-email';
	var errorPassword= 'error-password';
	var errorCurrentJob='error-current-job';
	var errorCurrentCompany = 'error-current-company';
	var errorContactNo = "error-contactno";
	var errorBiography = "error-biography";
	var errorCity = "error-city";
	var errorCountry = "error-country";
	var errorSkills = "error-skills";
	

	var dataString = "";
	
	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/

	$( '#password' ).keydown(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});

	$( '#password' ).keyup(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});
	

	$( '#email' ).keydown(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#email' ).keyup(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#fname' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorFName);
		}else{
			randomeErrorMsg(errorFName,"");
		}
	});

	$( '#lname' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorLName);
		}else{
			randomeErrorMsg(errorLName,"");
		}
	});
	
		$( '#city' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorCity);
		}else{
			randomeErrorMsg(errorCity,"");
		}
	});
	
	
		$( '#country' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorCountry);
		}else{
			randomeErrorMsg(errorCountry,"");
		}
	});
	
	
	
	$( '#current-job' ).keydown(function(e) {
		if (!checkalpha(e)){
			alphaErrorMsg(errorCurrentJob);
		}else{
			randomeErrorMsg(errorCurrentJob,"");
		}
	});
	
	$( '#contactno' ).keyup(function(e) {
		if (checkNum(e)){
			if (!checkPhoneLength(contactNo)){
				phoneLengthErrorMsg(errorContactNo);
			}else{
				randomeErrorMsg(errorContactNo,"");
			}
		}else{
			numErrorMsg(errorContactNo);
		}
	});
	
	


	/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(event){


        if(checkBlank(fname) || checkBlank(lname) || checkBlank(email) || checkBlank(password) ||
        checkBlank(currentJob) ||checkBlank(currentCompany) || checkBlank(contactNo) || checkBlank(city) ||
        checkBlank(country))
        {
        	event.preventDefault();
           blankErrorMsg(fname,errorFName);
           blankErrorMsg(lname,errorLName);
           blankErrorMsg(email,errorEmail);
           blankErrorMsg(password,errorPassword);
           blankErrorMsg(currentJob,errorCurrentJob);
           blankErrorMsg(contactNo,errorContactNo);
    		blankErrorMsg(currentCompany,errorCurrentCompany);
    		blankErrorMsg(city,errorCity);
    		blankErrorMsg(country,errorCountry);

            if(!checkEmail(email)){
                emailPrintMsg(errorEmail);
                event.preventDefault();
            }

            if (!checkPasswordLength(password)){
                passwordLengthErrorMsg(errorPassword);
                event.preventDefault();
            }
            
            if (!checkPasswordLength(confirmedPassword)){
                passwordLengthErrorMsg(errorCnfPassword);
               	event.preventDefault();
            }
  
		}
		else{
		window.location.replace('profile-update-process');
		}
		
	}); // End of Validation for Update Profile
};


/* 
	Forget Validation
*/
function forgetPasswordValidation(){
	var email= 'email';

	var errorEmail= 'error-email';
	

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/

	$( '#email' ).keydown(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});

	$( '#email' ).keyup(function() {
		if (!checkEmail(email)){
			emailPrintMsg(errorEmail);
		}else{
			randomeErrorMsg(errorEmail,"");
		}
	});



		/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(event){

        if(checkBlank(email))
        {
        	event.preventDefault();
            blankErrorMsg(email,errorEmail);

            if(!checkEmail(email)){
                emailPrintMsg(errorEmail);
                event.preventDefault();
            }

		}
		else{
		window.location.replace('reset-password');
		}
		
	}); // End of Validation for Forget Password
};


function resetPasswordValidation(){
	var password= 'password';
	var confirmedPassword = "confirmed-password";

	var errorPassword= 'error-password';
	var errorCnfPassword='error-confirmed-password';
		

	/*
	ACTION TAKEN ONCE A CERTAIN EVENT TRIGGER 
	*/

	$( '#password' ).keydown(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});

	$( '#password' ).keyup(function() {
		if (!checkPasswordLength(password)){
			passwordLengthErrorMsg(errorPassword);
		}else{
			randomeErrorMsg(errorPassword,"");
		}
	});
	
	$( '#confirmed-password' ).keydown(function() {
		if (!checkPasswordLength(confirmedPassword)){
			passwordLengthErrorMsg(errorCnfPassword);
		}else{
			randomeErrorMsg(errorCnfPassword,"");
		}
	});

	$( '#confirmed-password' ).keyup(function() {
		if (!checkPasswordLength(confirmedPassword)){
			passwordLengthErrorMsg(errorCnfPassword);
		}else{
			randomeErrorMsg(errorCnfPassword,"");
		}
	});
	



		/*
	HAPPEN ONCE USER CLICK SUBMIT BUTTON - Register
	*/
    $("#submit").click(function(event){

        if(checkBlank(password) || checkBlank(confirmedPassword)
        || !checkConfirmedPassword(confirmedPassword,password))
        {
        	event.preventDefault();
            blankErrorMsg(password,errorPassword);
            blankErrorMsg(confirmedPassword,errorCnfPassword);

            if (!checkPasswordLength(password)){
                passwordLengthErrorMsg(errorPassword);
                event.preventDefault();
            }
            
            if (!checkPasswordLength(confirmedPassword)){
                passwordLengthErrorMsg(errorCnfPassword);
                event.preventDefault();
            }
            
            if(!checkConfirmedPassword(confirmedPassword,password)){
            	randomeErrorMsg(errorCnfPassword,"Password must match Confirmed Password!");
            	event.preventDefault();
            }

		}
		else{
		window.location.replace('reset-password-status');
		}
		
	}); // End of Validation for register
};