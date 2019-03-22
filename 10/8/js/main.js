function showName(str) {
  console.log("uuuu");
  if(str=="")
  {
    document.getElementById('textName').innerHTML="";
  }
  if(window.XMLHttpRequest)
  {
    var xhttp= new XMLHttpRequest();
  }
  else {
    xhttp = new ActiveXObject("Message.xhttp");
  }
    xhttp.onreadystatechange = function() {
      if (this.readyState===4 && this.status===200) {
            document.getElementById("textName").innerHTML=this.responseText;
      }
    };
xhttp.open("GET","frameworks.php?name="+str,true)
xhttp.send();



}
