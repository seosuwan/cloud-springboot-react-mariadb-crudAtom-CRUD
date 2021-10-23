package shop.jarviis.api.cloud.common;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

//보통 R이 리턴이다.
public interface CommonController<R , T>  {
    ResponseEntity<List<R>> findAll();
    ResponseEntity<R> getById(T id); //있을때
    ResponseEntity<String> save(R entity);
    ResponseEntity<Optional<R>> findById(T id); //있을수도있고 없으수도있을때 findById
    ResponseEntity<Boolean> existsById(T id);
    ResponseEntity<Long> count();
    ResponseEntity<String>  deleteById(T id);
}
