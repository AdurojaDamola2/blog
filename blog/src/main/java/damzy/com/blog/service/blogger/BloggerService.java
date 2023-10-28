package damzy.com.blog.service.blogger;

import damzy.com.blog.dto.request.RegisterBloggerDTO;

public interface BloggerService {

    void createBlogger(RegisterBloggerDTO blogger);
}
