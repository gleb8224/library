<#-- @ftlvariable name="users" type="kotlin.collections.List<com.example.models.User>" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <h3>Users</h3>
    <#list users?reverse as user>
        <div style="word-spacing: 20px">
            <p>
                <a href="/users/${user.id}">${user.id}</a>
                ${user.firstname}
                ${user.surname}
                ${user.birthday}
            </p>
        </div>
    </#list>
</@layout.header>