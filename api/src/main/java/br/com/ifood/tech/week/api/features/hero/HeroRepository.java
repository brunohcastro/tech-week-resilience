package br.com.ifood.tech.week.api.features.hero;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface HeroRepository extends CrudRepository<Hero, UUID> {
}
