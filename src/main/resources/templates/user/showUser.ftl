<#-- @ftlvariable name="user" type="com.example.models.User" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <p style="word-spacing: 20px">
            ${user.id}
            ${user.firstname}
            ${user.surname}
            ${user.birthday}
        </p>
        <hr>
        <p>
            <a style="margin-right: 30px" href="/users/${user.id}/edit">Edit user</a>
            <a style="margin-right: 30px" href="/users">Accept</a>
        </p>
    </div>
</@layout.header>