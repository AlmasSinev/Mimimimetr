package com.ildarado.mimimimetr.repos;

import com.ildarado.mimimimetr.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepo extends JpaRepository<Cat, Long> {

    Cat findByName(String name);

    List<Cat> findTop10ByOrderByVoicesCountDesc();
}
