package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;



class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }
    @Test
    public void testFileKV() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertThat(storage.get("key","default")).isEqualTo("value");
        assertThat(storage.get("key2","default")).isEqualTo("default");
        assertThat(storage.toMap()).isEqualTo(Map.of("key","value"));
        storage.set("key","eulav");
        assertThat(storage.get("key","default")).isEqualTo("eulav");
        storage.unset("key");
        assertThat(storage.get("key","default")).isEqualTo("default");
    }

    // BEGIN
    
    // END
}
