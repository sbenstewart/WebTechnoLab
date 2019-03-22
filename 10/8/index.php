<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <script type="text/javascript" src="js/main.js">

    </script>
    <title></title>
  </head>
  <body>
<h2>Search Engine</h2>
<p><b>Type the first letter</b>
</p>
<form class="fomclass" action="index.php" method="post">
  <p>
  <input type="text"  id = "hint" onkeyup="showName(this.value)">
  </p>
</form>
<p> matches :: <span id="textName"></span> </p>
  </body>
</html>
