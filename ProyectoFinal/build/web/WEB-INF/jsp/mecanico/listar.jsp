<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Clientes</title>
        <jsp:include page="/WEB-INF/jsp/cabecera.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Listar Cliente</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-primary btn-md" href="<s:url value="/libros/create"/>">Crear Cliente</a>
                    <br><br>
                    <table class="table table-striped table-bordered table-hover" id="tabla">
                        <thead>
                            <tr>
                                <th>ID mecanico</th>
                                <th>Nombre usuario</th>
                                <th>Contraseña</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>Telefono Dos</th>
                                <th>Direccion</th>
                                <th>Dui</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.listarMecanico}" var="mecanico">
                                <tr>
                                    <td>${mecanico.idmecanico}</td>
                                    <td>${mecanico.nombreusu}</td>
                                    <td>${mecanico.contraseña}</td>
                                    <td>${mecanico.nombre}</td>
                                    <td>${mecanico.telefono}</td>
                                    <td>${mecanico.telefono2}</td>
                                    <td>${mecanico.direccion}</td>
                                    <td>${mecanico.dui}</td>
                                   <!-- <td>
                                        <a class="btn btn-primary"
                                           href="<s:url value="/libros/edit/${libro.codigoLibro}"/>">
                                            <span class="glyphicon glyphicon-edit"></span> Editar</a>
                                        <a class="btn btn-danger"
                                           href="javascript:eliminar('${libro.codigoLibro}')">
                                            <span class="glyphicon glyphicon-trash"></span> Eliminar</a>
                                    </td>-->
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#tabla').DataTable();
            });
            
            function eliminar(id) {
                alertify.confirm("Eliminar puta", function (e) {
                    if (e) {
                        location.href = "delete/" + id;
                    }
                });
            }
        </script>
        <jsp:include page="/WEB-INF/jsp/pie.jsp"/>
    </body>
</html>