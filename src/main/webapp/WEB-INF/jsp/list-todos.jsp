<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Todos for ${name}</title>
        <!-- Load CSS at earlier stage -->
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
            rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <H1>Your Todos</H1>
            <table class="table table-striped">
                <caption> Your todos are</caption>
                <thread>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is it done?</th>
                        <th>Delete</th>
                    </tr>
                </thread>
                <body>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.desc}</td>
                            <td>${todo.targetDate}<td>
                            <td>${todo.done}<td>
                            <!-- passing in param to href-->
                            <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
                        <tr>
                    </c:forEach>
                </body>
            </table>
            Hi ${name} (Step 12: Session)
            </br>
            Here is the list of your todos: (Step 10: Model, Hard-code)
            <br/>
            ${todos}
            <br/>
            <div>
                <a class="btn" href="/add-todo">Add a Todo</a>
            </div>
            <!-- Load javascript later -->
            <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
            <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>