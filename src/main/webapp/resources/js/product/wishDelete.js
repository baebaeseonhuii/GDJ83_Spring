//배열이라 직접적으로 이벤트를 못 걸어줌
const wishDelete = document.getElementsByClassName("wishDelete");


for(let w of wishDelete) {
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        w.parentNode.parentNode.remove();
    });
}