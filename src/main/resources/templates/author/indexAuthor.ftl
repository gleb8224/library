<#-- @ftlvariable name="authors" type="kotlin.collections.List<com.example.models.Author>" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <h3>Authors</h3>
    <#list authors?reverse as author>
        <div style="word-spacing: 20px">
            <p>
                <a href="/authors/${author.id}">${author.id}</a>
                ${author.firstname}
                ${author.surname}
                ${author.patronymic}
                ${author.birthday}
            </p>
        </div>
    </#list>
</@layout.header>