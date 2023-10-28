package damzy.com.blog.controller.blogger;

import damzy.com.blog.dto.request.RegisterBloggerDTO;
import damzy.com.blog.dto.response.ResponseDetails;
import damzy.com.blog.exception.AppException;
import damzy.com.blog.service.blogger.BloggerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/endpoint/blogger")
@Slf4j
public class BloggerController {

    @Autowired
    BloggerServiceImplementation bloggerServiceImplementation;

    @PostMapping("/create-blogger")
    public ResponseEntity<?> createBlogger(@RequestBody RegisterBloggerDTO registerBloggerDTO){
        bloggerServiceImplementation.createBlogger(registerBloggerDTO);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Created successfully.", HttpStatus.OK.toString());
        return ResponseEntity.ok(responseDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlogger(@PathVariable String id) throws AppException {
        bloggerServiceImplementation.deleteBlogger(id);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Deleted account successfully.", HttpStatus.OK.toString());
        return ResponseEntity.ok(responseDetails);
    }
}
