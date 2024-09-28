@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1> Посты </h1>
            @for(var post: page.getPosts())
                <a href="${NamedRoutes.postPath(post.getId())}"><h2>${post.getName()}</h2></a>
            @endfor
        </main>
        @if(page.getPageNumber() > 1)
            <h3><a href="${NamedRoutes.postsPath(page.getPageNumber()-1)}">Предыдущая</a></h3>
        @endif
        @if(page.getPageNumber()<page.getTotalPages())
            <h3><a href ="${NamedRoutes.postsPath(page.getPageNumber()+1)}"> Следующая</a></h3>
        @endif
    </div>
`
)
