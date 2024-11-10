package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    // END
    public AuthorDTO add(AuthorCreateDTO dto) {
        var author = authorMapper.map(dto);
        authorRepository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }
    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();
        var result = authors.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }
    public AuthorDTO findById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }
    public AuthorDTO update(AuthorUpdateDTO authorData, Long id) {
        var post = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        authorMapper.update(authorData, post);
        authorRepository.save(post);
        var authorDTO = authorMapper.map(post);
        return authorDTO;
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
