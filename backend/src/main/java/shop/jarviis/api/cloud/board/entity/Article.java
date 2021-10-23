package shop.jarviis.api.cloud.board.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;
import shop.jarviis.api.cloud.item.entity.Item;
import shop.jarviis.api.cloud.user.domain.User;

import javax.persistence.*;

@Entity
@Data
@Component
@Table
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;

    @Column(length = 50) @NotNull
    private String title;
    @Column(length = 200) @NotNull private String content;
    @Column(name = "written_date", length = 20) @NotNull private String writtenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}