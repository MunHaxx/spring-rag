package fr.efrei.spring_rag.web.rest;

import fr.efrei.spring_rag.domain.Document;
import fr.efrei.spring_rag.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class DocumentResource {

    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        Document result = documentService.buildAndSaveDocument(document);
        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable(value = "id", required = false) Long id) {
        Document result = documentService.findById(id).orElse(null);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/documents")
    public ResponseEntity<Iterable<Document>> getDocuments() {
        Iterable<Document> result = documentService.findAll();
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable(value = "id", required = false) Long id) {
        documentService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}