package fab.chemist.db.spring.db.framework.repository.interf;

import java.io.Serializable;

public interface PagingAndSortingRepository<T, ID extends Serializable>
extends CrudRepository<T, ID> {

Iterable<T> findAll(Sort sort);

Page<T> findAll(Pageable pageable);
}
