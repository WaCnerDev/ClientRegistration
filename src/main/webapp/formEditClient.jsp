<div class="container">
    <div class="row">
        <div class="col-sm-12 mx-auto">
            <div class="card mt-5 mb-5">
                <h5 class="card-header">Client Edit Form</h5>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/ServletControlador" method="POST" class="was-validated">

                        <input type="hidden" class="form-control" id="accion" name="accion" value="editClient" required>

                        <input type="hidden" class="form-control" id="clientId" name="clientId" value="${infClient.clientId}"required>

                        <div class="mb-3">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" value="${infClient.clientName}" required>
                        </div>

                        <div class="mb-3">
                            <label for="lastName" class="col-form-label">Last name:</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" value="${infClient.clientLname}" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="col-form-label">Email address:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" value="${infClient.clientEmail}" required>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="col-form-label">Phone:</label>
                            <input type="tel" class="form-control" id="phone" name="phone" value="${infClient.clientPhone}" required>
                        </div>

                        <div class="mb-3">
                            <label for="TotalSales" class="col-form-label">Total Sales:</label>
                            <input type="number" class="form-control" id="TotalSales" name="TotalSales" value="${infClient.clientTotalSales}" required>
                        </div>

                        <div class="col-12">
                            <a href="client.jsp"  class="btn btn-danger">Cancel</a>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


