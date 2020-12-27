<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <H1>Your Todos</H1>
    Hi ${name} (Step 12: Session)
    </br>
    Here is the list of your todos: (Step 10: Model, Hard-code)
    <br/>
    <table class="table table-striped">
        <caption> Your todos are</caption>
        <thread>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is it done?</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thread>
        <body>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy"
                                                        value="${todo.targetDate}" />
                    </td>
                    <td>${todo.done}</td>
                    <!-- passing in param to href-->
                    <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
                    <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
                <tr>
            </c:forEach>
        </body>
    </table>
    <div>
        <a class="btn" href="/add-todo">Add a Todo</a>
    </div>
<%@ include file="common/footer.jspf" %>