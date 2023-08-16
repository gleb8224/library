<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create book</h3>
        <form action="/books" method="post">
            <p>
                name:
                <input type="text" name="name">
            </p>
            <p>
                genre:
                <input type="text" name="genre">
            </p>
            <p>
                publish date:
                <input type="text" name="publishdate">
            </p>
            <p>
                author id:
                <input type="text" name="authorid">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>