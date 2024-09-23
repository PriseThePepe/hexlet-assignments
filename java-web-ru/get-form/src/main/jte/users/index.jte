@import exercise.dto.users.UsersPage
@import exercise.model.User
@import java.util.stream.Collectors
@param UsersPage page





@template.layout.page(
content = @`
    <a href="/users">Пользователи</a>
    <form action="/users" method="get">
        <input type = "search" name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    <h1> ${page.getUsers().stream().map(p -> p.getFirstName() + " " + p.getLastName()).collect(Collectors.joining(", "))}</h1>
`
)
