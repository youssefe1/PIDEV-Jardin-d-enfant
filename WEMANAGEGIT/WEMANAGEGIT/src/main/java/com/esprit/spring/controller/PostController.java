package com.esprit.spring.controller;

import com.esprit.spring.dto.PostDto;
import com.esprit.spring.dto.UploadFileResponse;
import com.esprit.spring.service.PostService;
import com.esprit.spring.service.impl.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/post")

public class PostController {


    @Autowired
    PostService postService;
    @Autowired
    private FileStorageService fileStorageService;




    @PostMapping("")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){



        return this.postService.createPost(postDto);
    }
@GetMapping("")
public ResponseEntity<?> getAllPosts(){
   return      this.postService.getAllPost();

}

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getPostsUser(@PathVariable("id") long id){
return postService.getPostByUserId(id);

    }
@PutMapping("")
    public ResponseEntity<?> updatePost(@RequestBody PostDto postDto){
        return this.postService.updatePost(postDto);
}
@DeleteMapping("")
    public ResponseEntity<?> deletePost(@RequestBody PostDto postDto){

     return    this.postService.deletePost(postDto);
}
@PostMapping("/like")
    public ResponseEntity<?> likePost(@RequestBody PostDto postDto){

     return    this.postService.likePost(postDto);

}
    @PostMapping("/dislike")
    public ResponseEntity<?> dislikePost(@RequestBody PostDto postDto){

        return    this.postService.dislikePost(postDto);

    }
    @DeleteMapping("/removeLikeDislike")
        public ResponseEntity<?> removeLikeDislikePost(@RequestBody PostDto postDto){

        return this.postService.removelikeDislikePost(postDto);
        }

    @GetMapping("/likeByuser/{id}")
    public ResponseEntity<?> getlikeByUserId(@PathVariable("id") long id){

        return postService.getLikeByUserId(id);

    }
    @GetMapping("/likeByPost/{id}")
    public ResponseEntity<?> getlikeByPostId(@PathVariable("id") long id){

        return postService.getLikeByPostId(id);

    }
    @PostMapping("uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        //    logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



}
