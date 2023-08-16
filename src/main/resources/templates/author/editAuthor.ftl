<#-- @ftlvariable name="author" type="com.example.models.Author" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit author</h3>
        <form action="/authors/${author.id}" method="post">
            <p>
                <input type="text" name="firstname" value="${author.firstname}">
            </p>
            <p>
                <input type="text" name="surname" value="${author.surname}">
            </p>
            <p>
                <input type="text" name="patronymic" value="${author.patronymic}">
            </p>
            <p>
                <input type="text" name="birthday" value="${author.birthday}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/authors/${author.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>