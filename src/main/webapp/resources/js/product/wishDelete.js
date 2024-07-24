//배열이라 직접적으로 이벤트를 못 걸어줌
const wishDelete = document.getElementsByClassName("wishDelete");
const allCheck = document.getElementById("allCheck");
const check = document.getElementsByClassName("check");
const delAll = document.getElementById("delAll");

for(let w of wishDelete) {
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");

        //server 삭제 요청
        //option js의 객체 형식
        //js에서는 let a = {} 이런게 객체
        fetch("./deleteWishList?p_code=" + id, {
            method: "GET"

        }).then((r)=>{return r.text()})
          .then((r)=>{
            r=r.trim();//공백제거
            if(r>0) {
                let del = w.getAttribute("data-del-id");
                document.getElementById(del).remove();

            } else {
                alert("삭제 실패");
            }
          }).catch(()=>{
            alert("오류 발생");
          })


    });
}

delAll.addEventListener("click", ()=>{
    let url = "deleteWishList?";
    const e = [];
    for(let c of check) {
        if(c.checked) {
            let p_code = c.getAttribute("data-wish-id");
            url = url + "p_code=" + p_code + "&";
            e.push(c.getAttribute("data-del-id"));
        }
    }
    url = url.substring(0, url.length-1);
    console.log(url);
    // fetch("") //fetch는 한번만
    fetch(url, {
        method: "GET",

    }).then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0) {
            for(let ele of e) {
                document.getElementById(ele).remove();
               // ele.parentNode.parentNode.remove();
            }
            // for(let c of check) {
            //     if(c.checked){
            //         c.parentNode.parentNode.remove();
            //     }
            // }
        }else {
            alert("삭제되지 않았습니다.");
        }
    })
    .catch(()=>{alert("오류 발생")});
})


allCheck.addEventListener("click", ()=> {
    for(let c of check) {
        c.checked = allCheck.checked;
    }

    for(let c of check) {
        c.addEventListener("click", ()=>{
            let flag = true;
            for(let ch of check) {
                if(ch.checked == false) {
                    flag = false;
                    break;
                }
            }
            allCheck.checked = flag;
        })
    }   
})

