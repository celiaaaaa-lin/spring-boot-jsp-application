<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    Hi ${name} (Step 12: Session)
    Add TODO
    <!-- Step 13: Add Todo
        <form method="post">
            <fieldset class="form-group">
                <label>Description</label>
                <input name="desc" type="text" class="form-control" required="required"/>
            </fieldset>
            <button type="submit" class="btn btn-success">Add</button>
        </form>
    -->
    <!-- Step 18: Command Bean -->
    <form:form method="post" modelAttribute="todo">
        <!-- Step 19: Hidden field which contains id and resolve null id issue on return-->
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <!-- Step 20: Target date -->
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>