package com.study.springboot.dto;

// ArticleDTO
public class ArticleForm {
    private String title;  // 제목
    private String content;  // 내용

    // 마우스 우클릭 - 생성 - 생성자
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 마우스 우클릭 - 생성- toString()
    // 폼 데이터를 잘 받았는지 확인
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
