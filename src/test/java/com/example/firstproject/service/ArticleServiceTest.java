package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired ArticleService artcleServie;


    @Test
    void index() {

        List<Article> expected = new ArrayList<>(Arrays.asList(new Article(1L,"H","123"),new Article(2L,"T","456"),new Article(3L,"W","789"),new Article(4L,"J","012")));

        //실제
        List<Article> articles = artcleServie.index();

        //비교
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show_sucess() {
        //예상
        Long id = 1L;
        Article expected = new Article(id,"H","123");
        //실제
        Article article = artcleServie.show(id);
        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    void show_fail() {
        //예상
        Long id = -1L;
        Article expected = null;
        //실제
        Article article = artcleServie.show(id);
        //비교
        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void create_sucess() {
        //예상
        String title = "K";
        String content = "321";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(5L,title,content);

        //실제
        Article article = artcleServie.create(dto);

        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    @Transactional
    void create_fail() {
        //예상
        String title = "K";
        String content = "321";
        ArticleForm dto = new ArticleForm(3L,title,content);
        Article expected = null;

        //실제
        Article article = artcleServie.create(dto);

        //비교
        assertEquals(expected,article);
    }


    @Test
    @Transactional
    void update_sucess() {
        //예상
        Long id = 1L;
        String title = "Joker";
        String content = "HaHaHa";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = new Article(id,title,content);

        //실제
        Article article = artcleServie.update(id,dto);

        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    @Transactional
    void update_fail() {
        //예상
        Long id = -1L;
        String title = "Joker";
        String content = "HaHaHa";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null;

        //실제
        Article article = artcleServie.update(id,dto);

        //비교
        assertEquals(expected,article);
    }
}