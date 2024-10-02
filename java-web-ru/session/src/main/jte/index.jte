@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page



@template.layout.page(
content =@`
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
    @if(page.getName() != null)
        Добро пожаловать, ${page.getName().toString()}.
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" name="Выйти">
        </form>
    @endif
    @if(page.getName() == null)
        <h1>Добро пожаловать.</h1>
        <h2><a href="${NamedRoutes.buildSessionPath()}">Войти</a></h2>
    @endif
</main>
</body>
</html>
`)