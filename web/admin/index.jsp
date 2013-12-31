<%--
  Created by IntelliJ IDEA.
  User: roman_b
  Date: 10/21/13
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin tool</title>

    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery-1.9.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery-ui.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/index.js"></script>

    <link rel="stylesheet" href="../styles/jquery-ui.css"/>
    <link rel="stylesheet" href="/admin/styles/index.css">

    <!--Price imports-->

    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery.dataTables.rowGrouping.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery.multiselect.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/libs/jquery.multiselect.filter.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/PriceController.js"></script>


    <link rel="stylesheet" href="../styles/multiSelect/jquery.multiselect.css"/>
    <link rel="stylesheet" href="../styles/jquery-ui-1.10.3.custom.css"/>
    <link rel="stylesheet" href="../admin/styles/treatment.css"/>


</head>
<body>

<div id="navigationTabs">
    <ul class="navigation-tabs">
        <li id="priceTab"><a href="/admin/price.html">Price</a></li>
        <li id="doctorsTab"><a  href="/admin/doctors.jsp">Doctors</a></li>
        <li id="appointmentsTab"><a  href="/admin/appointments.jsp">Appointments</a></li>
    </ul>
</div>

</body>
</html>