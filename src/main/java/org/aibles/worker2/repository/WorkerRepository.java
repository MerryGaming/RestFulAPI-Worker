package org.aibles.worker2.repository;

import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>  {
//    @Query(value = "SELECT * FROM worker p WHERE p.name LIKE %:query%",nativeQuery = true)
//    List<Worker> searchWorker(@Param("query") String query);
@Query(value = "SELECT p FROM Worker p WHERE p.name LIKE %:query%")
List<Worker> searchWorker(@Param("query") String query);
}
//oke 2 kiểu đều ra kết quả cả rồi . em để ý chỗ p kia nên để là chữ cái đầu của tên bảng nhé
// có 2 cách viết query bằng @Query 1 là jpql(hql) 2 là sql em đọc thêm nhé
//chỗ kia em viết query bị sai đấy nên nó không nhận được
