package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.ResponseResult;
import org.example.domain.entity.Article;
import org.example.mapper.ArticleMapper;
import org.example.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper , Article> implements ArticleService {

    @Override
    public ResponseResult<Article> hotArticleList() {
        //查询热门文章并返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<Article>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus,0);

        //按照浏览量降序排序
        queryWrapper.orderByDesc(Article::getViewCount);

        //最多查询十条
        Page<Article> page = new Page<>(1,10);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();
        ResponseResult result = ResponseResult.okResult(articles);
        return result;
    }
}
