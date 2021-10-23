package shop.jarviis.api.cloud.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.jarviis.api.cloud.item.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
