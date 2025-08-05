<!-- The include directive is used to include the contents of 
any resource it may be jsp file, 
html file or text file. The include directive includes the 
original content of the included resource at 
page translation time (the jsp page is translated only 
once so it will be better to include static resource).
 -->
 
 <!-- 
 
 | Feature                      | `%@ include file="..." %`                                  | `jsp:include page="..." `                                        |
| ---------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------------- |
| 📅 **Inclusion Time**        | **Compile-time (static include)**                            | **Runtime (dynamic include)**                                       |
| 🔄 **Change Detection**      | Changes in included file require recompilation               | Changes are reflected immediately                                   |
| 🔧 **Use Case**              | For including static content like headers/footers            | For dynamic content that might change during execution              |
| 📁 **File Merging**          | Contents are **copied** into the main JSP before translation | Included content is **executed separately**, and output is inserted |
| 🧪 **Can use `	jsp:param`** 	| ❌ No                                                         | ✅ Yes                                                               |
| 🧠 **Performance**           | Slightly faster (compiled once)                              | Slightly slower (processed at runtime)                              |
 
  -->
 <body bgcolor="yellow" text="red">

<%@include file="JSPDemo.jsp" %>
 
 <h1>Next.....</h1>
 
 <!-- JSP:PARAM IS A CHILD TAG OF JSP:INCLUDE -->
 
 <!-- JSP:PARAM IS A CHILD TAG OF JSP:INCLUDE -->
<jsp:include page="Inc1.jsp">
<jsp:param value="Java" name="Training"/>
<jsp:param value="Chennai" name="Location"/>
</jsp:include>
