<body bgcolor=pink>
<h1>

<%@page isELIgnored="false"%>

<!-- NO JAVA CODE COMPLETELY TAG ORIENTED PROGRAM  -->
<!-- With scriptless JSP, embedding too much code in the page can
 be avoided thus resulting in a neat JSP page. -->
<!-- jsp:usebean tag is used for locate any java bean classes!. 
id: is used to identify the bean(object) -->

<jsp:useBean id="b1" class="myservletdemos.Supplier"/>

<!-- NO PARAM TAG BCOS USING EL SYNTAX -->
<!-- EL can be used in ANY JSP TAG -->

<jsp:setProperty name="b1" property="supplierid" value="${param.supplierid1}"/>
<jsp:setProperty name="b1" property="suppliername" value="${param.suppliername1}"/>

<!-- instead of getter methods to display, use jsp:getProperty tag -->
<!-- getProperty print the result directly! -->
GetProperty::
<jsp:getProperty name="b1" property="supplierid"/>
<jsp:getProperty name="b1" property="suppliername"/>

<p>ExpressionLanguage::
SupplierId::${b1.supplierid}
SupplierName::${b1.suppliername}
<p>
SupplierId::${b1.getSupplierid()}
SupplierName::${b1.getSuppliername()}