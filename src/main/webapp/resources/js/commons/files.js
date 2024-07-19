
const fileBtn = document.getElementById("fileBtn");
const fileDiv = document.getElementById("fileDiv");

//부모의 id값으로 사용
let idx = 0;

//최대 첨부 파일 갯수
let max = 1;

//만든 횟수
let count = 0;

function setMax(m) {
    max = m;
}

fileDiv.addEventListener("click", function(e){
    if(e.target.localName == "span"){
        document.getElementById(e.target.getAttribute("data-del-id")).remove();
        count--;
    }
})

fileDiv.addEventListener("mouseover", function(e){
    if(e.target.localName == "span"){
        e.target.classList.add('hand-cursor');
    }
})

fileDiv.addEventListener("mouseout", function(e){
    if(e.target.localName == "span"){
        e.target.classList.remove('hand-cursor');
    }
})

fileBtn.addEventListener("click", function(){
    if(count >= max){
        alert('파일은 최대 '+max+'개만 추가할 수 있습니다');
        return;
    } 
    let addFileDiv = document.createElement("div");
    let addFile = document.createElement("input");
    let sp = document.createElement("span");
    let wrapper = document.createElement("div");
    
    wrapper.id = "file" + idx;

    addFile.setAttribute("type", "file");
    addFile.classList.add("form-control");
    addFile.name="files";

    sp.classList.add("input-group-text");
    sp.innerText = "X";
    sp.setAttribute("data-del-id", "file" + idx++);

    addFileDiv.append(sp);

    wrapper.classList.add("input-group");
    wrapper.classList.add("mt-3");

    wrapper.append(addFile);
    wrapper.append(addFileDiv);

    fileDiv.append(wrapper);
    count++;
})