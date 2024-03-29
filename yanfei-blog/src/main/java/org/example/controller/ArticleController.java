package org.example.controller;

import org.example.domain.ResponseResult;
import org.example.domain.entity.Article;
import org.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

//    @RequestMapping("/list")
//    public List<Article> test(){
//     return articleService.list();
//    }
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        //查询热门文章并返回
        ResponseResult result = articleService.hotArticleList();
        return result;

    }
}
