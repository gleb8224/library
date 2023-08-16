<#-- @ftlvariable name="author" type="com.example.models.Author" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <p style="word-spacing: 20px">
            ${author.id}
            ${author.firstname}
            ${author.surname}
            ${author.patronymic}
            ${author.birthday}
        </p>
        <hr>
        <p>
            <a style="margin-right: 30px" href="/authors/${author.id}/edit">Edit author</a>
            <a style="margin-right: 30px" href="/authors">Accept</a>
        </p>
    </div>
</@layout.header>