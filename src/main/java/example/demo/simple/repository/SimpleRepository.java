package example.demo.simple.repository;

import example.demo.simple.entity.Simple;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRepository extends CrudRepository<Simple, String> {
}
