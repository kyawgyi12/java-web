<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="login">
      <div class="login-screen">
        <div class="login-icon">
          <img src="resources/img/ygn.png" alt="Welcome to Mail App">
          <h4>Welcome to <small>Yangon Navi</small></h4>
        </div>

        <div class="login-form">
          <div class="form-group">
            <input class="form-control login-field" placeholder="Enter your name" id="login-name" type="text">
            <label class="login-field-icon fui-user" for="login-name"></label>
          </div>

          <div class="form-group">
            <input class="form-control login-field" placeholder="Password" id="login-pass" type="password">
            <label class="login-field-icon fui-lock" for="login-pass"></label>
          </div>

          <a class="btn btn-primary btn-lg btn-block" href="#">Log in</a>
          <a class="login-link" href="#">Lost your password?</a>
        </div>
      </div>
    </div>