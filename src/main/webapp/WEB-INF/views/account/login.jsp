<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#LoginBtn").click(function() {
			var me_email = $("#me_email").val();
			var me_id = $("#me_id").val();
			var me_pwd = $("#me_pwd").val();

			if (document.frm.me_email.value == "") {
				alert("이메일을 입력해 주세요.");
				return false;
			}

			if (document.frm.me_pwd.value == "") {
				alert("비밀번호를 입력해 주세요.");
				return false;
			}

			if (me_email != "" && me_pwd != "") {
				return "/account/login";
			}

		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var msg = "${msg}"

		if (msg != "") {
			alert(msg);
		}
	});
</script>
<script type="text/javascript">
const signup = document.getElementById("sign-up");
signin = document.getElementById("sign-in");
loginin = document.getElementById("login-in");
loginup = document.getElementById("login-up");

signup.addEventListener("click", () => {
    loginin.classList.remove("block");
    loginup.classList.remove("none");

    loginin.classList.add("none");
    loginup.classList.add("block");
})

signin.addEventListener("click", () => {
    loginin.classList.remove("none");
    loginup.classList.remove("block");

    loginin.classList.add("block");
    loginup.classList.add("none");
})
</script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Login</title>
<link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/51db22a717.js"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css2?family=Alata&display=swap"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>
	<form name="frm" action="/account/login" method="post">
		<div class="login">
			<div class="login__content">
				<div class="login__img">
					<img
						src="https://image.freepik.com/free-vector/code-typing-concept-illustration_114360-3581.jpg"
						alt="user login">
				</div>
				<div class="login__forms">
					<!--         login form -->
					<h1 class="login__title">WithComm 관리자</h1>
					<div class="login__box">
						<i class='bx bx-user login__icon'></i> <input type="email"
							placeholder="아이디" id="me_email" name="me_email" class="login__input">
					</div>
					<div class="login__box">
						<i class='bx bx-lock login__icon'></i> <input type="password"
							placeholder="패스워드" id="me_pwd" name="me_pwd" class="login__input">
					</div>
					<a href="#" class="login__forgot">계정을 잊으신 분은 관리자에게 문의 바랍니다. </a> 
					<button type="submit" class="login__button center btn-right" id="login-btn" name="login-btn">Sign In</button>

					<!-- <div>
						<span class="login__account login__account--account">Don't
							Have an Account?</span> <span
							class="login__signin login__signin--signup" id="sign-up">Sign
							Up</span>
					</div> -->

					<!--         create account form -->
					<!-- <form action="" class="login__create none" id="login-up">
          <h1 class="login__title">Create Account</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="Username" class="login__input">
          </div>
          
          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="Email" class="login__input">
          </div>
          
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="Password" class="login__input">
          </div>
          
          <a href="#" class="login__button">Sign Up</a>
          
          <div>
            <span class="login__account login__account--account">Already have an Account?</span>
            <span class="login__signup login__signup--signup" id="sign-in">Sign In</span>
          </div>
          
          <div class="login__social">
             <a href="#" class="login__social--icon"><i class='bx bxl-facebook'></i></a>
             <a href="#" class="login__social--icon"><i class='bx bxl-twitter'></i></a>
             <a href="#" class="login__social--icon"><i class='bx bxl-google'></i></a>
             <a href="#" class="login__social--icon"><i class='bx bxl-github'></i></a>
          </div> -->

				</div>
			</div>
		</div>
	</form>

<style type="text/css">
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap");
*, ::before, ::after {
  box-sizing: border-box;
}

.btn-right {
	float: right;
}

body {
  margin: 0;
  padding: 0;
  font-family: "Open Sans", sans-serif;
  font-size: 0.938rem;
  color: #23004d;
}

h1 {
  margin: 0;
}

a {
  text-decoration: none;
}

img {
  max-width: 100%;
  height: auto;
  display: block;
}

.login {
  display: grid;
  grid-template-columns: 100%;
  height: 100vh;
  margin-left: 1.5rem;
  margin-right: 1.5rem;
}
.login__content {
  display: grid;
}
.login__img {
  justify-self: center;
}
.login__img img {
  width: 310px;
  margin-top: 1.5rem;
}
.login__forms {
  position: relative;
  height: 368px;
}
.login__register, .login__create {
  position: absolute;
  bottom: 1rem;
  width: 100%;
  background-color: #f2f2f2;
  padding: 2rem 1rem;
  border-radius: 1rem;
  text-align: center;
  box-shadow: 0 8px 20px rgba(35, 0, 77, 0.2);
  animation-duration: 0.4s;
  animation-name: animateLogin;
}
.login__title {
  font-size: 1.5rem;
  margin-bottom: 2rem;
  text-align: center;
}
.login__box {
  display: grid;
  grid-template-columns: max-content 1fr;
  column-gap: 0.5rem;
  padding: 1.125rem 1rem;
  background-color: #fff;
  margin-top: 1rem;
  border-radius: 0.5rem;
}
.login__icon {
  font-size: 1.5rem;
  color: #4AD395;
}
.login__input {
  border: none;
  outline: none;
  font-size: 0.938rem;
  font-weight: 700;
  color: #23004d;
  width: 100%;
}
.login__input::placeholder {
  font-size: 0.938rem;
  font-family: "Open Sans", sans-serif;
  color: #a49eac;
}
.login__forgot {
  display: block;
  width: max-content;
  margin-left: auto;
  margin-top: 0.5rem;
  font-size: 0.813rem;
  font-weight: 600;
  color: #a49eac;
}
.login__button {
  display: block;
  padding: 1rem;
  margin: 2rem 0;
  background-color: #4AD395;
  color: #fff;
  font-weight: 600;
  text-align: center;
  border-radius: 0.5rem;
  transition: 0.3s;
}
.login__button:hover {
  background-color: #65bf97;
}
.login__account, .login__signin, .login__signup {
  font-weight: 600;
  font-size: 0.813rem;
}
.login__account--account, .login__signin--account, .login__signup--account {
  color: #23004d;
}
.login__account--signin, .login__account--signup, .login__signin--signin, .login__signin--signup, .login__signup--signin, .login__signup--signup {
  color: #4AD395;
  cursor: pointer;
}
.login__social {
  margin-top: 2rem;
}
.login__social--icon {
  font-size: 1.5rem;
  color: #23004d;
  margin: 0 1rem;
}

.block {
  display: block;
}

.none {
  display: none;
}

@keyframes animateLogin {
  0% {
    transform: scale(1, 1);
  }
  50% {
    transform: scale(1.1, 1.1);
  }
  100% {
    transform: scale(1, 1);
  }
}
@media screen and (min-width: 576px) {
  .login__forms {
    width: 348px;
    justify-self: center;
  }
}
@media screen and (min-width: 1024px) {
  .login {
    height: 100vh;
    overflow: hidden;
  }
  .login__content {
    grid-template-columns: repeat(2, max-content);
    justify-content: center;
    align-items: center;
    margin-left: 10rem;
  }
  .login__img {
    display: flex;
    width: 600px;
    height: 588px;
    background-color: #fff;
    border-radius: 1rem;
    padding-left: 1rem;
  }
  .login__img img {
    width: 80%;
    margin-top: 0;
  }
  .login__register, .login__create {
    left: -11rem;
  }
  .login__register {
    bottom: -2rem;
  }
  .login__create {
    bottom: -5.5rem;
  }
}
</style>