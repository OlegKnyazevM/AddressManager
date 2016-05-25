<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script language="javascript" type="text/javascript" src="/resources/js/view.js"></script>

<table  style=" margin: auto;" id="ttt" border="1px" style="color: black">
    <tr>
        <td class="col1" align="center" >content: </td>
        <td  align="center" >${content}</td>
    </tr>
    <tr>
        <td class="col1" align="center" >country: </td>
        <td  align="center" >${country}</td>
    </tr>
    <tr>
        <c:forEach var="phones" items="${phones}">
            <table style=" margin: auto;" id="ttt1" border="1px" style="color: black" >
                <tr>
                    <td class="col1" align="center" >phones: </td>
                    <td  align="center" > ${phones}</td>
                </tr>
            </table>
        </c:forEach>
    </tr>
</table>
<div id='txt' >
    <a href='/'>
        <p style="text-align: center"><button class='great_btn'>Back</button> </p>
    </a>
</div>
<div id='box' ></div>
