<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailCheckForm.jsp</title>
</head>
<body>
  <div style="text-align: center">
    <h3>* 이메일 중복확인 *</h3>
    <form method="post"
          action="emailCheckProc.jsp"
          onsubmit="return blankCheck(this)">
    이메일:<input type="text" name="email" maxlength="20" autofocus>
           <input type="submit" value="중복확인">
    </form>
  </div>
  
  <script>
  function blankCheck(f){
	  var email=f.email.value;
	  email=email.trim();
	  if(email.length<5){
		  alert("이메일은 5글자 이상 입력해 주세요");
		  return false;
	  }//if end
	  return true;
  }//end
  </script>
</body>
</html>

