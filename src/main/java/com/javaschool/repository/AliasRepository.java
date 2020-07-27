package com.javaschool.repository;

import com.javaschool.entity.Alias;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AliasRepository extends CrudRepository<Alias, Long> {

    Optional<Alias> findByUrl(String url);

    Optional<Alias> findByAlias(String alias);


}
