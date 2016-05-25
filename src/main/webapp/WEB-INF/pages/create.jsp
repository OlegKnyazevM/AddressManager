<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.05.2016
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">


<div>
    <form action="/address/create" method="post" id="add-address">
        <table class="table1" style=" margin: auto;  background: #fffacd;" border="1px" style="color: black">
            <tr>
                <td  align="center" >content:</td>
                <td  align="center" ><input type="text" value="" name="content"></td>
            </tr>
            <tr>
                <td  align="center" >phone:</td>
                <td  align="center" ><input type="text" value="" name="phone"></td>
            </tr>
            <tr>
                <td  align="center" >country:</td>
                <td  align="center" >
                    <select name="country">
                        <option selected value="UKRAINE">UKRAINE</option>
                        <option value="GERMANY">GERMANY</option>
                        <option value="RUSSIAN_FEDERATION">RUSSIAN_FEDERATION</option>
                        <option value="UNITED_KINGDOM">UNITED_KINGDOM</option>
                        <option value="UNITED_STATES">UNITED_STATES</option>
                    </select>
                </td>
            </tr>
            <tr >
                <td rowspan="4" align="center" > <input class='great_btn' type="submit"></td>
            </tr>
        </table>
    </form>
</div>