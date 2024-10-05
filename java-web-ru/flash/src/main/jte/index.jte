@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page




@template.layout.page(
    page = page,
    content = @`
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        p.flash-message {
            background-color: #cce5ff;
            color: #004085;
            border: 1px solid #b8daff;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
    </head>
    <body>
        <h2>Welcome to Hexlet</h2>
    @if(page != null)
        @for(var post : page.getPosts())
            <h1>${post.getName()}</h1>
            <h2>${post.getBody()}</h2>
            <h2><a href="${NamedRoutes.buildPostPath()}"> Добавить пост </a></h2>
        @endfor
    @else
        <h1>Не добавлено ни одного поста</h1>
        <h2><a href="${NamedRoutes.buildPostPath()}"> Добавить пост </a></h2>
    @endif
    </body>
`
)
