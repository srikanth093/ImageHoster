package ImageHoster.repository;

import ImageHoster.model.Comments;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentsRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //This method receives an image id, and gets the comments related to that image
    public List<Comments> getComments(Integer imageId){
        EntityManager entityManager = emf.createEntityManager();

        TypedQuery<Comments> typedQuery = entityManager.createQuery("SELECT c from Comments c WHERE c.image.id = :imageId", Comments.class);
        typedQuery.setParameter("imageId",imageId);

        return typedQuery.getResultList();

    }

    //SRThis comment receives a comment and adds it in the comments table
    public Comments createComment(Comments comment){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(comment);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }

        return comment;

    }

}
