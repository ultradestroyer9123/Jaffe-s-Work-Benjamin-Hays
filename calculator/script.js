let isOutput = true;
let launchedOrCleared = true;
var currentData = "0;";
let inp = document.getElementById('input');



function updateOutput(cd) {
    cd = cd.replace(/;/g,"")
    if (cd == "" || cd == null) {
        cd = " "
    }
    document.getElementById("output").innerHTML = cd
}

function appendKey(key) {
    if (key == "=") {
        isOutput = true;
        return
    }
    if (isOutput == true) {
        isOutput = false;
        if ("0123456789".includes(key) || launchedOrCleared) {
            currentData = key + ";";
            launchedOrCleared = false;
        } else {
            currentData = currentData + key + ";";
        }
    } else {
        currentData = currentData + key + ";"
    }
    updateOutput(currentData)
}
console.log(inp)
for (var i = 0; i < inp.children.length; i++) {
    var current = inp.children[i];
    var id = current.id;
    var type = current.tagName;
    if (type == "BUTTON") {
        (function(current) {
            current.addEventListener("click", function() {
                if (current.id == "backspace") {
                    var cS = currentData.split(";");
                    cS = cS.slice(0,cS.length-2).join(";") + ";";
                    currentData = cS
                    updateOutput(cS);
                } else {
                    appendKey(current.innerHTML);
                }
                console.log(current.id);
            });
        })(current);
    }
}

