package com.yurets_y.mydevelopercv.controller;


import com.yurets_y.mydevelopercv.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController()
@RequestMapping("/download")
public class FilesController {

    private ResourceService resourceService;

    @GetMapping("/cv")
    public ResponseEntity<Resource> serveFile(
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String format,
            HttpServletRequest request
    ) throws FileNotFoundException {

        Resource resource = resourceService.getCvFile(language,format);

        String contentType = "application/octet-stream";
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }
        if(contentType == null){
            contentType = resourceService.getContentType(resource.getFilename());
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }
}
