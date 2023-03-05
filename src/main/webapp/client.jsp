<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html style="html, body {
          height: 100%;
          width: 100%;
      }" data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--add CDN css and icons of Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <title>Control of clients</title>
    </head>
    <body style="height: 100%">
        <jsp:include page="formAddClient.jsp"/>

        <!--JSP Component of header-->
        <jsp:include page="WEB-INF/pagesComuns/header.jsp"/>

        <!--JSP Component of buttons-->
        <jsp:include page="WEB-INF/pagesComuns/navbuttons.jsp"/>

        <!--JSP Component of table-->
        <jsp:include page="WEB-INF/pagesComuns/clientsTable.jsp"/>

        <!-- footer of the application-->
        <jsp:include page="WEB-INF/pagesComuns/footer.jsp"/>

        <!--add CDN javascript of bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </body>
</html>
