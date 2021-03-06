package lt.fivethreads.services;

import lt.fivethreads.entities.request.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    FileDTO upload(MultipartFile file, String filename);
    FileDTO getFileById(long fileId);
    File getFileDownload(long fileId);
    void deleteFile(String filename);
}
