@import exercise.dto.users.UserPage
@import exercise.model.User
@param UserPage page

@template.layout.page(
 content = @`
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>User</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        @if(page.getUser() != null)
            <h1>User: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
            <h2>User email: ${page.getUser().getEmail()}</h2>
            <h2>User ID: ${page.getUser().getId()}</h2>
        @endif
        <div>
            <h3> <a href="/users">Go back to users</a></h3>
        </div>
    </main>
</div>
</body>
</html>
`)