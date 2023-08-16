<#-- @ftlvariable name="book" type="com.example.models.Book" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <p style="word-spacing: 20px">
            ${book.id}
            ${book.name}
            ${book.genre}
            ${book.publishdate}
            ${book.authorid}
        </p>
        <hr>
        <p>
            <a style="margin-right: 30px" href="/books/${book.id}/edit">Edit book</a>
            <a style="margin-right: 30px" href="/books">Accept</a>
        </p>
    </div>
</@layout.header>