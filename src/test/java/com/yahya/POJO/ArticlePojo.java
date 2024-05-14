package com.yahya.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlePojo {

    // source json field is another json object
    // you can either map or use another pojo to represent it
    private Map<String, Object> source;
    private String author;
    private String title;
}
