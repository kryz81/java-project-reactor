package kryz.basics_and_mono.assignment1;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public static Mono<String> read(String path) {
        return Mono.fromSupplier(() -> {
            try {
                return getFileContent(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static String getFileContent(String path) throws IOException {
        Path path1 = Path.of(path);
        try {
            return Files.readString(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
