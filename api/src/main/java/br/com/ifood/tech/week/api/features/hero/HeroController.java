package br.com.ifood.tech.week.api.features.hero;

import br.com.ifood.tech.week.api.toggle.FeatureToggle;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes")
@CacheConfig(cacheNames = "heroes")
public class HeroController {

    public final HeroRepository repository;

    @GetMapping
    @Cacheable()
    @FeatureToggle(feature = "feature.heroes.list")
    public Iterable<Hero> findHeroes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Hero findHeroById(@PathVariable("id") UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
