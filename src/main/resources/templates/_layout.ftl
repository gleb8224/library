<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>library</title>
    </head>
    <body style="font-family: sans-serif">
    <h1>Library</h1>
    <hr>
    <a style="margin: 15px" href="/">Main Page</a>
    <a style="margin: 15px" href="/users">Users</a>
    <a style="margin: 15px" href="/authors">Authors</a>
    <a style="margin: 15px" href="/books">Books</a>
    <a style="margin: 15px" href="/librarycards">Library Cards</a>
    <hr>
    <a style="margin: 15px" href="/users/new">Create User</a>
    <a style="margin: 15px" href="/authors/new">Create Author</a>
    <a style="margin: 15px" href="/books/new">Create Book</a>
    <a style="margin: 15px" href="/librarycards/new">Create Library card</a>
    <hr>
    <#nested>
    </body>
    </html>
</#macro>