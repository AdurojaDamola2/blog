package damzy.com.blog.repository.blogger;

import damzy.com.blog.model.blogger.Blogger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends MongoRepository<Blogger, String> {}
