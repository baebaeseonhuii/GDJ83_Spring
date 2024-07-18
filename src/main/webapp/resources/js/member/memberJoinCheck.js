/**
 * 
 */

//  alert('memberJoinCheck');

const join = document.getElementById("join");
const sm = document.getElementById("sm");

const inputs = document.getElementsByTagName("input");
const pw_error = document.getElementById("pw_error");

sm.addEventListener("click", function () {
    pw_error.innerHTML = "";
    if (inputs[0].value == '') {
        alert("ID를 입력하세요");
        inputs[0].focus();
    } else if (inputs[1].value == '') {
        pw_error.innerHTML = "PW를 입력하세요";
        inputs[1].focus();
    } else if (inputs[2].value == '') {
        alert("이름을 입력하세요");
        inputs[2].focus();
    } else if (inputs[3].value == '') {
        alert("전화번호를 입력하세요");
        inputs[3].focus();
    } else if (inputs[4].value == '') {
        alert("email을 입력하세요");
        inputs[4].focus();
    } else if(inputs[5].value == ''){
        alert("주민번호를 입력하세요");
        inputs[5].focus();
    } else if (inputs[1].value.length < 8) {
        pw_error.innerHTML = "PW는 8글자 이상이어야 합니다";
    }else {
        join.submit();
    }

});