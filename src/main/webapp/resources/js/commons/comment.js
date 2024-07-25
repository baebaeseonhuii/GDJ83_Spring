const commentContents = document.getElementById("commentContents");
const commentButton = document.getElementById("commentButton");
const commentList = document.getElementById("commentList");
const commentClose = document.getElementById("commentClose");
const commentDelete = document.getElementById("delBtn");

getCommentList(1);


function getCommentList(page){
    
    fetch("./commentList?p_code=" + commentButton.getAttribute("data-product-id") +"&page=" + page, {
        method: "GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}



commentList.addEventListener("click", (e)=>{
    let productId = commentButton.getAttribute("data-product-id");
    if(e.target.classList.contains("pn")) {
        let p = e.target.getAttribute("data-page-num");
        getCommentList(p);
        
    }
    let delId = 0;
    if(e.target.classList.contains("delBtn")) {
        delId = e.target.getAttribute("data-del-btn");
    }

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
        } else {
            
        }
    })
    .catch(()=>{
        alert("오류");
    })
})



commentButton.addEventListener("click", ()=>{
    let productId = commentButton.getAttribute("data-product-id");
    let userId = commentButton.getAttribute("data-user-id");
    commentClose.click();
    let contents = commentContents.value;
    commentContents.value="";

    fetch("./commentAdd", {
        method: "POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: "boardContents=" + contents + "&p_code=" + productId + "&boardWriter=" + userId
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