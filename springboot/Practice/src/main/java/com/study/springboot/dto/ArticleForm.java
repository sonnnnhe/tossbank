package com.study.springboot.dto;

import com.study.springboot.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

// ArticleDTO
@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;  // 제목
    private String content;  // 내용

    // Entity로 변환하는 함수
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
