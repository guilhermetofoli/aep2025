<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="LoginServLet" method="post">
            <div class="form-group">
                <label for="txtName">Nome de Usuário</label>
                <input type="text" name="txtName" id="txtName">
            </div>
            <div class="form-group">
                <label for="txtPwd">Senha</label>
                <input type="password" name="txtPwd" id="txtPwd">
            </div>
            <div class="form-group">
                <input type="submit" value="Login">
            </div>
            <div class="form-group">
                <input type="reset" value="Redefinir">
            </div>
        </form>
    </div>
</body>
</html>
