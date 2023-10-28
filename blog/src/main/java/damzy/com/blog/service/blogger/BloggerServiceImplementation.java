package damzy.com.blog.service.blogger;

import damzy.com.blog.dto.request.RegisterBloggerDTO;
import damzy.com.blog.exception.AppException;
import damzy.com.blog.model.blogger.Blogger;
import damzy.com.blog.repository.blogger.BloggerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloggerServiceImplementation implements BloggerService{

    @Autowired
    BloggerRepository bloggerRepository;

    public boolean existById(String id){
        return bloggerRepository.existsById(id);
    }

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public void createBlogger(RegisterBloggerDTO registerBloggerDTO) {
        Blogger blogger = new Blogger();
        blogger.setFirstName(registerBloggerDTO.getFirstName());
        blogger.setLastName(registerBloggerDTO.getLastName());
        modelMapper.map(blogger, registerBloggerDTO);
        bloggerRepository.save(blogger);

    }

    @Override
    public void deleteBlogger(String id) throws AppException {
        Optional<Blogger> currentBlogger = bloggerRepository.findById(id);
        if (currentBlogger.isPresent()) {
            bloggerRepository.deleteById(id);
        } else {
            throw new AppException("User with ID " + id + " not found");
        }
    }


}
