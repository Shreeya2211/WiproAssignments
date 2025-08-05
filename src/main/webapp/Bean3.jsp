<body bgcolor="yellow" text="blue">

<h1>Java Bean Details:</h1>

<!-- HTML+JAVA BEAN CLASS+JSP -->


<jsp:useBean id="bbb" class="myservletdemos.Supplier"/>

<!-- property=* means Automatically map all request parameters to matching JavaBean properties by name  -->

<jsp:setProperty name="bbb" property="*" />


<!-- instead of getter methods to display, use jsp:getProperty tag -->
<!-- getProperty print the result directly! -->
<jsp:getProperty name="bbb" property="supplierid"/>
<jsp:getProperty name="bbb" property="suppliername"/>
	