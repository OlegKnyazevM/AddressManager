<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">




<a href='/address/create'>
    <p style="text-align: center"><button class='great_btn'>Create</button> </p>
</a>


<form action="/address/deleteAddress" method="post" id="del-address">
    <p style="text-align: center"><input style="width: 150px" placeholder="Address" name="content">
        <button class='great_btn'>Delete Address</button> </p>
</form>


<form action="/address/deletePhone" method="post" id="del-phone">
    <p style="text-align: center"><input style="width: 150px" placeholder="Phone" name="number">
        <button class='great_btn'>Delete Phone</button> </p>
</form>


<form action="/address/searchAddress" method="get" id="search-address">
    <p style="text-align: center"><input style="width: 150px" placeholder="Address" name="content">
        <button class='great_btn'>Search Address</button></p>
</form>

<form action="/address/searchPhone" method="get" id="search-phone">
    <p style="text-align: center"><input style="width: 150px" placeholder="Phone" name="number">
        <button class='great_btn'>Search Phone</button></p>
</form>

