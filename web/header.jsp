<%-- 
    Document   : header
    Created on : Sep 21, 2017, 8:10:14 AM
    Author     : VuCuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="headCss.css">
<!DOCTYPE html>

<div class="styleDivHead">
    <div class="styleLogo"  >
        <img class="styleImage" src="image/logo.PNG"/>
    </div>
    <form>
        <div class="styleFindAndSubmitUserName">
            <div class="styleFindUsername">
                <input class="styleTextFindUsername" placeholder="Find" type="text" name="findUser"/>
            </div>
            <div class="styleSubmit" >
                <button style="width: 30px;height: 30px;">
                    <img src="image/find.png" width="29" height="27"/>
                </button>
            </div>

        </div>
    </form>


    <div class="styleProfile">
        <div class="styleViewProfile">
            <button style="margin-top: 4px;margin-left: 4px;" onclick="window.location.href = 'index.jsp'">
                <img style="width: 30px;height: 30px" src="image/imageClone.jpg"/>
            </button>
        </div>
        <div class="styleHome">
            <button onclick="window.location.href = 'index.jsp'">
                <img src="image/home.png" width="30" height="30"/>
            </button>
        </div>

    </div>



</div>
