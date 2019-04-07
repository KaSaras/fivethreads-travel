package lt.fivethreads.controller;

import lt.fivethreads.importing.EventImportService;
import lt.fivethreads.importing.UserImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImportController {

    @Autowired
    UserImportService userImportService;

    @Autowired
    EventImportService eventImportService;

    @PostMapping("/admin/user/import")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> importUsers(@RequestParam("file") MultipartFile file) {
        userImportService.importUsers(file);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/admin/event/import")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> importEvents(@RequestParam("file") MultipartFile file) {
        eventImportService.importEvents(file);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
