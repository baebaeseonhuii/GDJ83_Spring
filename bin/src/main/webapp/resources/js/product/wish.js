const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult")

//Arrow Function

//평범한 함수 선언 
//function [함수명] () {}
//Arrow function
//()=>{}
addWish.addEventListener("click", (e)=>{
    let id = addWish.getAttribute("data-product-id");
    let userID = addWish.getAttribute("data-user-id");
    

    fetch("./addWish?p_code=" + id, {
                method: "GET"
            })
            .then((res)=>{return res.text()})
            .then((res) =>{
                if(res > 0) {
                    let check = confirm("관심등록 확인하시겠습니까?");
                    if(check) {
                        location.href="./wishList?id=" + userID;
                    }
                } else {
                    alert("이미 있는 상품");
                }
            })
            .catch(()=>{
                alert("오류 발생");
            })
})

//function(res) {
//return res.text();
//}
// addWish.addEventListener("click", function() {
//     fetch("./addWish?num=15&name=seon", {
//         method: "GET"
//     })
// })