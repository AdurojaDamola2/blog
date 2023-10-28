package damzy.com.blog.service.blogger;

import damzy.com.blog.dto.request.RegisterBloggerDTO;
import damzy.com.blog.model.blogger.Blogger;
import damzy.com.blog.repository.blogger.BloggerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloggerServiceImplementation implements BloggerService{

    @Autowired
    BloggerRepository bloggerRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public void createBlogger(RegisterBloggerDTO registerBloggerDTO) {
        Blogger blogger = new Blogger();
        blogger.setFirstName(registerBloggerDTO.getFirstName());
        blogger.setLastName(registerBloggerDTO.getLastName());
        modelMapper.map(blogger, registerBloggerDTO);
        bloggerRepository.save(blogger);

    }
}
