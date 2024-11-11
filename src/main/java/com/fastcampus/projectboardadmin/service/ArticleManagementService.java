package com.fastcampus.projectboardadmin.service;

import com.fastcampus.projectboardadmin.dto.ArticleDto;
import com.fastcampus.projectboardadmin.dto.properties.ProjectProperties;
import com.fastcampus.projectboardadmin.dto.response.ArticleClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleManagementService {

    private final RestTemplate restTemplate;
    private final ProjectProperties projectProperties;

    public List<ArticleDto> getArticles() {
        // 서비스에 존재하는 모든 게시글을 한 번에 가져오기 위해 임의의 큰 숫자를 size 파라미터로 설정했다.
        // TODO: 좀 더 안정적인 동작을 원한다면 해당 요청을 하기 전 서비스에 존재하는 게시글 숫자를 먼저 읽어오면 된다.
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles")
                .queryParam("size", 10000)
                .build()
                .toUri();
        ArticleClientResponse response = restTemplate.getForObject(uri, ArticleClientResponse.class);

        return Optional.ofNullable(response)
                .orElseGet(ArticleClientResponse::empty)
                .articles();
    }

    public ArticleDto getArticle(Long articleId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .build()
                .toUri();
        ArticleDto response = restTemplate.getForObject(uri, ArticleDto.class);

        return Optional.ofNullable(response)
                .orElseThrow(() -> new NoSuchElementException("게시글이 없습니다 - articleId: " + articleId));
    }

    public void deleteArticle(Long articleId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .build()
                .toUri();
        restTemplate.delete(uri);
    }

}
