<#-- @ftlvariable name="books" type="kotlin.collections.List<com.example.models.Book>" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <h3>Books</h3>
    <#list books?reverse as book>
        <div style="word-spacing: 20px">
            <p>
                <a href="/books/${book.id}">${book.id}</a>
                ${book.name}
                ${book.genre}
                ${book.publishdate}
                <a href="/authors/${book.authorid}">${book.authorid}</a>
            </p>
        </div>
    </#list>
</@layout.header>