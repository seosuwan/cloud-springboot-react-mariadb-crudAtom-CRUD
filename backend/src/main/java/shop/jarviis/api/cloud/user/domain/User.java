package shop.jarviis.api.cloud.user.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;
import shop.jarviis.api.cloud.board.entity.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Component @Table(name = "users") @Proxy(lazy = false)
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동증가. 없으면 덮어씌워진다.
    private Long userId;

    @Column(length = 50) @NotNull private String username;
    @Column(length = 10) @NotNull private String password;
    @Column(length = 50) @NotNull private String name;
    @Column(length = 50) @NotNull private String email;
    @Column(name = "reg_date", length = 20) @NotNull private String regDate;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Article> articleList = new ArrayList<>();
}
