let errpass = document.querySelector('#err-pass')

function showErrPass(errpass,message){
    errpass.classList.add('error')
    errpass.innerText = message
}
function showSuccessPass(errpass){
    errpass.innerText = ''
}

function showerror(input, message) {
    const span = input.nextElementSibling
    span.classList.add('error')
    span.innerText = message
}

function showsuccess(input) {
    const span = input.nextElementSibling
    span.innerText = ''
}
function checknull(input){
	if(input.value.trim() === ""){
		 showerror(input, 'Không được bỏ trống ')
	}else{
		 showsuccess(input)
	}
	
}
function checkNoteEmpty(input) {
    return input.value.trim() !== "";
}

function checkPass(input) {
    const regexPass = /(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;
    if (checkNoteEmpty(input)) {
        if (regexPass.test(input.value)) {
          showSuccessPass(errpass)
        } else {
            showErrPass(errpass,'Password có ít nhật 1 chữ IN HOA, 1 chữ in thường và chữ số có độ dài ít nhất 8 kí tự')
        }
    } else {
        showErrPass(errpass,"Password không được bỏ trống")
    }
}

function checkEmail(input) {
    const regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (checkNoteEmpty(input)) {
        if (regexEmail.test(input.value)) {
            showsuccess(input)
        } else {
            showerror(input, 'Email chưa đúng định dạng')
        }
    } else {
        showerror(input, "Email không được bỏ trống")
    }
}
function checkID(input) {
    const regexID = /^(?=.*[a-zA-Z])(?=.*\d).{5,}$/
    if (checkNoteEmpty(input)) {
        if (regexID.test(input.value)) {
            showsuccess(input)
        } else {
            showerror(input, 'Username chỉ bao gồm ít nhất một chữ cái thường và số có độ dài ít nhất 5 kí tự')
        }
    } else {
        showerror(input, "Username không được bỏ trống")
    }
}

function checkFulname(input) {
    const regexFullname = /^(?=.{20,})[a-zA-Z\u00C0-\u00FF\s']+$/
    if (checkNoteEmpty(input)) {
        if (regexFullname.test(input.value)) {
            showsuccess(input)
        } else {
            showerror(input,'Fulname chưa đúng định dạng')
        }
    } else {    
        showerror(input, "Fullname không được bỏ trống")
    }


}

