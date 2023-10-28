package damzy.com.blog.service.blogger;

import damzy.com.blog.dto.request.RegisterBloggerDTO;
import damzy.com.blog.exception.AppException;

public interface BloggerService {

    void createBlogger(RegisterBloggerDTO blogger);

    void deleteBlogger(String id) throws AppException;


}
