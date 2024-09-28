@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>${(page.getPost().getName())}</h1>
            <h2>${page.getPost().getId()}</h2>
            <h2>${page.getPost().getBody()}</h2>
        </main>
        <h3><a href ="${NamedRoutes.postsPath()}">Вернуться к списку постов</a></h3>
    </div>
`
)
