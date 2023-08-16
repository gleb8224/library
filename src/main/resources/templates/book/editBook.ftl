<#-- @ftlvariable name="book" type="com.example.models.Book" -->
<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit book</h3>
        <form action="/books/${book.id}" method="post">
            <p>
                <input type="text" name="name" value="${book.name}">
            </p>
            <p>
                <input type="text" name="genre" value="${book.genre}">
            </p>
            <p>
                <input type="text" name="publishdate" value="${book.publishdate}">
            </p>
            <p>
                <input type="text" name="authorid" value="${book.authorid}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/books/${book.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>