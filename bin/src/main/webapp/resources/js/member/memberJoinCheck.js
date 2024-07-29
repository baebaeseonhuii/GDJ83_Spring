/**
 * 
 */

//  alert('memberJoinCheck');

const join = document.getElementById("join");
const sm = document.getElementById("sm");
const pwChk = document.getElementById("pwChk");
const inputs = document.getElementsByTagName("input");
const idCheck = document.getElementById("idCheck");

idCheck.addEventListener("change", ()=>{
    let id = idCheck.value;
    console.log(id);
    fetch("./idDuplicationcheck?id=" + id, {
        method: "GET"
    }).then((r)=>{return r.text()})
      .then((r)=>{
        if(r == id) {
            
        }
      })
})

inputs[1].addEventListener("change", function() {
    pwChk.innerHTML = "비밀번호가 일치합니다";
    pwChk.classList.remove("text-danger");
    pwChk.classList.add("text-success");
    if (inputs[1].value != inputs[2].value){
        pwChk.innerHTML = "비밀번호가 다릅니다";
        pwChk.classList.remove("text-success");
        pwChk.classList.add("text-danger");
    }
})

inputs[2].addEventListener("change", function(){
    pwChk.innerHTML = "비밀번호가 일치합니다";
    pwChk.classList.remove("text-danger");
    pwChk.classList.add("text-success");
    if (inputs[1].value != inputs[2].value){
        pwChk.innerHTML = "비밀번호가 다릅니다";
        pwChk.classList.remove("text-success");
        pwChk.classList.add("text-danger");
    }
})

sm.addEventListener("click", function () {
    pwChk.innerHTML = "비밀번호가 일치합니다";
    pwChk.classList.remove("text-danger");
    pwChk.classList.add("text-success");
    if (inputs[0].value == '') {
        alert("ID를 입력하세요");
        inputs[0].focus();
    } else if (inputs[1].value == '') {
        alert("PW를 입력하세요");
        inputs[1].focus();
    } else if (inputs[2].value == '') {
        alert("PW Check를 입력하세요");
        inputs[2].focus();
    } else if (inputs[3].value == '') {
        alert("이름을 입력하세요");
        inputs[3].focus();
    } else if (inputs[4].value == '') {
        alert("전화번호를 입력하세요");
        inputs[4].focus();
    } else if (inputs[5].value == '') {
        alert("email을 입력하세요");
        inputs[5].focus();
    } else if(inputs[6].value == ''){
        alert("주민번호를 입력하세요");
        inputs[6].focus();
    } else if (inputs[1].value.length < 8) {
        alert("PW는 8글자 이상이어야 합니다");
    }else if (inputs[1].value != inputs[2].value){
        pwChk.innerHTML = "비밀번호가 다릅니다";
        pwChk.classList.remove("text-success");
        pwChk.classList.add("text-danger");
        inputs[2].focus();
    } else{
        join.submit();
    }

});