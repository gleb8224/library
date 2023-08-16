<#import "../_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create user</h3>
        <form action="/users" method="post">
            <p>
                firstname:
                <input type="text" name="firstname">
            </p>
            <p>
                surname:
                <input type="text" name="surname">
            </p>
            <p>
                birthday:
                <input type="date" name="birthday">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>