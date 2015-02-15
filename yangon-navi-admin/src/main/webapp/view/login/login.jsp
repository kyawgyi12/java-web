<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="login">
      <div class="login-screen">
        <div class="login-icon">
          <img src="${baseUrl.url('resources/img/ygn.png')}" alt="Welcome to Mail App">
          <h4>Welcome to <small>Yangon Navi</small></h4>
        </div>

        <div class="login-form">
        <form action="${baseUrl.url('login/login')}" method="post">
          <div class="form-group">
            <input name="loginid" class="form-control login-field" placeholder="Enter your name" id="login-name" required="required" type="text">
            <label class="login-field-icon fui-user" for="login-name"></label>
          </div>

          <div class="form-group">
            <input name="pass" class="form-control login-field" placeholder="Password" id="login-pass" type="password" required="required">
            <label class="login-field-icon fui-lock" for="login-pass"></label>
          </div>

          <input class="btn btn-primary btn-lg btn-block" value="Log in" type="submit"/>
          <a class="login-link" href="#">Lost your password?</a>
        </form>
        </div>
      </div>
    </div>