<body bgcolor="yellow" text="blue">

<h1>Java Bean Details:</h1>

<!-- HTML+JAVA BEAN CLASS+JSP -->


<jsp:useBean id="bbb" class="myservletdemos.Supplier"/>

<!-- instead of setter methods, use jsp:setProperty tag -->
<!-- param attribute(TAKES THE TEXTBOX NAMES) only
 for "html code connected to javabean class" -->

<jsp:setProperty name="bbb" property="supplierid" param="supplierid1"/>

<jsp:setProperty name="bbb" property="suppliername" param="suppliername1"/>

<!-- instead of getter methods to display, use jsp:getProperty tag -->
<!-- getProperty print the result directly! -->
<jsp:getProperty name="bbb" property="supplierid"/>
<jsp:getProperty name="bbb" property="suppliername"/>
	

