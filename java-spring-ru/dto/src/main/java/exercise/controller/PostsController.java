package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
public class PostsController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/posts")
    public List<PostDTO> index() {
       var posts = postRepository.findAll();
        return posts.stream()
                .map(this::postToDTO)
                .toList();
    }
    private PostDTO postToDTO(Post post) {
        var dto = new PostDTO();
       var comments = commentRepository.findByPostId(post.getId())
                        .stream()
                        .map(this::commentToDTO)
                        .toList();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        dto.setComments(comments);
        return dto;
    }
    private CommentDTO commentToDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setBody(comment.getBody());
        dto.setId(comment.getId());
        return dto;
    }
    @GetMapping("/posts/{id}")
    public PostDTO show(@PathVariable long id) {
       var post = postRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return postToDTO(post);
    }
}
// END
