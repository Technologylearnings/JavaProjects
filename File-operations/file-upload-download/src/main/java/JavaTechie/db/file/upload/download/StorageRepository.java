package JavaTechie.db.file.upload.download;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<ImageData, Long> {

	Optional<ImageData> findByName(String filename);
}
