<div class="modal fade" id="addClientModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h1 class="modal-title fs-5">Add client</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/ServletControlador?accion=addClient" method="POST" class="was-validated">
                    <div class="mb-3">
                        <label for="name" class="col-form-label">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>

                    <div class="mb-3">
                        <label for="lastName" class="col-form-label">Last name:</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="col-form-label">Email address:</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                    </div>

                    <div class="mb-3">
                        <label for="phone" class="col-form-label">Phone:</label>
                        <input type="tel" class="form-control" id="phone" name="phone" required>
                    </div>

                    <div class="mb-3">
                        <label for="TotalSales" class="col-form-label">Total Sales:</label>
                        <input type="number" class="form-control" id="TotalSales" name="TotalSales" required>
                    </div>
                    
                    <div class="col-12">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>