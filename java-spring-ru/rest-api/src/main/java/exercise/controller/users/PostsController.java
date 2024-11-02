package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();
    
    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable String id) {
        Integer userId;
        try {
            userId = Integer.valueOf(id); // Преобразуем id в Integer
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid user ID: " + id); // Обработка ошибки формата
        }

        // Возвращаем список постов, написанных пользователем с заданным userId
        return posts.stream()
                .filter(p -> p.getUserId() == userId) // Фильтруем посты по userId
                .toList();
    }

    // Создание нового поста для пользователя
    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED) // Устанавливаем статус ответа при успехе
    public Post create(@PathVariable String id, @RequestBody Post newPost) {
        Integer userId;
        try {
            userId = Integer.valueOf(id); // Преобразуем id в Integer
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid user ID: " + id); // Обработка ошибки формата
        }

        // Устанавливаем userId для нового поста и добавляем в список
        newPost.setUserId(userId);
        posts.add(newPost); // Добавляем новый пост в общий список

        // Возвращаем созданный пост
        return newPost;
    }
}

// END
