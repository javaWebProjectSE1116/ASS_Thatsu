<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="loginCss.css">
    </head>
    <body>

        <div class="cont">
            <div class="demo">-->
                <div class="login">
                    <div class="login__check"></div>
                    <div class="login__form">
                        <form action="CheckLogin" method="POST">
                            <div class="login__row">
                                <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                                <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                                </svg>
                                <input type="text" name="username" class="login__input name" placeholder="username" />

                            </div>
                            <div class="login__row">
                                <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                                <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                                </svg>
                                <input type="password" name="password" class="login__input pass" placeholder="password" />
                            </div   >
                            <%
                                String errorPhone = request.getParameter("check");
                                if ("false".equals(errorPhone)) {
                                    out.print("<div class=\"login__row2\">");
                                    out.print("<p class=\"h4Style\">Wrong username or password</p>");
                                    out.print("</div>");
                                }
                            %>
                            <button type="submit" class="login__submit">Sign in</button>
                            <p class="login__signup">Don't have an account? &nbsp;<a class="aStyle" href="SignUp.jsp">Sign up</a></p>
                        </form>
                    </div>

                </div>

            </div>
        </div>

    </body>
</html>
