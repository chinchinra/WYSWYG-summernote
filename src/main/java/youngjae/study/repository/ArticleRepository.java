package youngjae.study.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import youngjae.study.domain.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>{


}
