<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en-US"/>
<section id="clients">
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <div class="card" style="max-height: 600px">
                    <div class="card-header bg-dark text-white">
                        <h4>Client list</h4>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-responsive-sm table-responsive-md table-responsive-lg table-responsive-xl">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Total Sales</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="client" items="${registerClients}">
                                    <tr>
                                        <td>${client.clientId}</td>
                                        <td>${client.clientName} ${client.clientLname}</td>
                                        <td><fmt:formatNumber value="${client.clientTotalSales}"/></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=editClient&clientId=${client.clientId}"
                                               class="btn btn btn-outline-secondary text-white" role="button">
                                                <i class="bi bi-pencil-square"></i> Edit
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=deleteClient&clientId=${client.clientId}"
                                               class="btn btn-outline-danger" role="button">
                                                <i class="bi bi-person-dash"></i> Delete
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h4 class="card-title">Total clients:</h4>
                        <h3 class="display-4">
                            <i class="bi bi-people"></i>
                            ${totalClients}
                        </h3>
                    </div>
                </div>
                <div class="card text-center bg-success text-white">
                    <div class="card-body">
                        <h4 class="card-title">Total revenue:</h4>
                        <h4>
                            <fmt:formatNumber value="${totalRevenue}" type="currency"/>
                        </h4>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>



