package com.example.demo.repo;

import java.util.Optional;

import javax.persistence.LockModeType;
import com.example.demo.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncrementRepo extends CrudRepository<Number, Integer>{
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Number> findById(int id);

	@Modifying
	@Query("update Number n set n.counter =:counter where n.id =:id")
	void updateCounter(int counter, int id);
}
