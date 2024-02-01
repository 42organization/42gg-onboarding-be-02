package com.gg.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    @Getter
    @Setter
    public static class createPostDto
    {
        private String title;
        private String content;

        public createPostDto() {}
        public createPostDto(String title, String content)
        {
            this.title = title;
            this.content = content;
        }
    }

    @Getter
    @Setter
    public static class deletePostDto
    {
        private Long id;

        public deletePostDto(Long id)
        {
            this.id = id;
        }
    }

    @Getter
    @Setter
    public static class readPostDto
    {
        private Long id;
        private String title;

        public readPostDto() {}
        public readPostDto(Long id, String title)
        {
            this.id = id;
            this.title = title;
        }
    }
}
