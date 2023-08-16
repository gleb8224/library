<#-- @ftlvariable name="user" type="com.example.models.User" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit user</h3>
        <form action="/users/${user.id}" method="post">
            <p>
                <input type="text" name="firstname" value="${user.firstname}">
            </p>
            <p>
                <input type="text" name="surname" value="${user.surname}">
            </p>
            <p>
                <input type="date" name="birthday" value="${user.birthday}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/users/${user.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>