<%-- 
    Document   : SignUp
    Created on : Oct 17, 2017, 12:01:17 AM
    Author     : NamNV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="loginCss.css">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="cont">
            <div class="demo">
                <div class="login">
                    <!--<div class="login__check"></div>-->
                    <div class="login__form" style="position: static">
                        <form action="CreateAccount" method="POST" name="form" onsubmit="return(validate());">

                            <div class="login__row">
                                <input type="text" class="login__input name" required="1" placeholder="First Name" maxlength="20"  tabindex="1" name="firstName" />
                            </div>
                            <div class="login__row">
                                <input type="text" class="login__input name" required="1" placeholder="Last Name" maxlength="20"  tabindex="1" name="lastName" />
                            </div>
                            <div class="login__row">
                                <input type="text" class="login__input name" required="1" placeholder="Username" maxlength="20"  tabindex="1" name="username" />
                            </div>

                            <%
                                String err = request.getParameter("checkUser");
                                if ("false".equals(err)) {
                                    out.print("<div class=\"login__row2\">");
                                    out.print("<p class=\"h4Style\">Account is exist</p>");
                                    out.print("</div>");
                                }
                            %>
                            <div class="login__row">
                                <input type="password" class="login__input pass" required="1" maxlength="25" placeholder="Password"  tabindex="1" name="password" />
                            </div   >
                            <!--radion buttion-->
                            <div class="login__radito">
                                <div class="styleradito" style="margin-left: 25px;">
                                    <input   type="radio" name="sex" required="1" value="Male"  />  
                                    <label for="sex">Male</label>
                                    <input style="margin-left: 48px" required="1"  type="radio" name="sex" value="Female" /> 
                                    <label for="sex">Female</label>
                                </div>
                            </div>


                            <div class="login__row">
                                <input type="email" class="login__input name" required="1" placeholder="Email"  tabindex="1" name="email" />
                            </div>
                            <div class="login__row">
                                <input type="text" class="login__input name" required="1" placeholder="Phone Number" maxlength="13"  tabindex="1" name="phoneNumber" />
                            </div>

                            <%
                                String errorPhone = request.getParameter("checkPhone");
                                if ("false".equals(errorPhone)) {
                                    out.print("<div class=\"login__row2\">");
                                    out.print("<p class=\"h4Style\">Phone must be number(10-12 character)</p>");
                                    out.print("</div>");
                                }
                            %>

                            <button type="submit" class="signUp__submit">Sign Up</button>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </body>
</html>
