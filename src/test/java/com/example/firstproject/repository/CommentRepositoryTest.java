package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //JPA와 연동한 테스트!
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        {
            // 입력 데이터 준비
            Long articleId =5L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            Article article = new Article(5L,"Food","comment go");
            Comment a = new Comment(1L,article,"JBH","pizza");
            Comment b = new Comment(2L,article,"JBH","chicken");
            Comment c = new Comment(3L,article,"JBH","Hamburger");

            List<Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(),comments.toString());
        }

        {
            // 입력 데이터 준비
            Long articleId =1L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            Article article = new Article(1L,"H","123");
            List<Comment> expected = Arrays.asList();

            //검증
            assertEquals(expected.toString(),comments.toString(),"1번글은 댓글이 없음");
        }

    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        {
            //입력 데이터를 준비
            String nickname = "JBH";
            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //예상하기



            //검증
            assertEquals(comments.toString(),comments.toString());
        }
    }
}