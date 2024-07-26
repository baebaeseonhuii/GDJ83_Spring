const commentContents = document.getElementById("commentContents");
const commentButton = document.getElementById("commentButton");
const commentList = document.getElementById("commentList");
const commentClose = document.getElementById("commentClose");
const openModal = document.getElementById("openModal");

getCommentList(1);


function getCommentList(page){
    
    fetch("./commentList?p_code=" + commentButton.getAttribute("data-product-id") +"&page=" + page, {
        method: "GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}

commentList.addEventListener("click", (e)=>{
   
    if(e.target.classList.contains("pn")) {
        let p = e.target.getAttribute("data-page-num");
        getCommentList(p);
        
    }
    

})

commentList.addEventListener("click", (e)=>{
    let productId = commentButton.getAttribute("data-product-id");
    if(e.target.classList.contains("delBtn")) {
        let delId = e.target.getAttribute("data-del-btn");
        fetch("./commentDelete", {
            method: "POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body: "boardNum=" + delId 
        })
        .then((r)=>{return r.text()})
        .then((r)=>{
            r.trim;
            if(r>0) {
                location.href="./detail?p_code=" + productId;
                getCommentList(1);
            } else {
                
            }
        })
        .catch(()=>{
            alert("오류");
        })
    }

})


let flag = true;

//openModal
openModal.addEventListener("click", ()=>{
    commentButton.innerHTML = "댓글 등록";
    commentContents.value = "" ;
    flag = true;
})

let bn = "";

//수정
commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")) {
        let id = e.target.getAttribute("data-update-btn");
        bn = id;
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        console.log(c);
        commentContents.value = c;
        commentButton.innerHTML="댓글 수정";
        flag=false;
    }

})


//등록, 수정
commentButton.addEventListener("click", ()=>{
    let productId = commentButton.getAttribute("data-product-id");
    let userId = commentButton.getAttribute("data-user-id");
    commentClose.click();
    let contents = commentContents.value;
    let url = "./commentAdd";
    let param = "boardContents=" + contents + "&p_code=" + productId + "&boardWriter=" + userId;
    const form = new FormData(); //form 태그를 만든거임
    form.append("boardContents", contents); //<input type="text", name="boardContents", value="contents값" />
    form.append("p_code", commentButton.getAttribute("data-product-id"));
    form.append("boardNum", bn);



    if(contents == null || contents == "") {
        alert("댓글을 입력하세요");
        return;
    }

    if(!flag) {
        url = "./commentUpdate";
        // param = "boardContents=" + contents + "&boardNum=" +  bn
        
    }
    
    
    fetch(url, {
        method: "POST",
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded"
        // },
        body: form
    })
    .then((r)=>{return r.text()})
    .then((r)=>{
        r.trim();
        if(r>0) {
            location.href="./detail?p_code=" + productId;
            getCommentList(1);
        } else {
            alert("오류");
        }
    })
    .catch(()=>{
        alert("오류");
    })
        
})