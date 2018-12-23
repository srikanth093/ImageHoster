package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comments> getComments(Integer imageId){
        return commentsRepository.getComments(imageId);
    }

    public void createComment(Comments comment){
        commentsRepository.createComment(comment);
    }
}
