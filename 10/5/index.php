<html>
<body>
<h2>JSON with PHP</h2>
<p id="demo"></p>
<script>
var xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function(){
if(this.readyState==4 && this.status==200)
{
	myObj=JSON.parse(this.responseText);
	document.getElementById("demo").innerHTML=myObj.name;
}
};
xmlhttp.open("GET","random.json",true);
xmlhttp.send();
</script>
</body>
</html>