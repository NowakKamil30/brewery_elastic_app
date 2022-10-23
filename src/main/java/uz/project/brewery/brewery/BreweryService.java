package uz.project.brewery.brewery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.project.brewery.common.AppSettings;
import uz.project.brewery.common.DataService;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
class BreweryService implements DataService<Brewery> {

    private final RestTemplate restTemplate;

    private final AppSettings appSettings;

    @Override
    public Set<Brewery> getAll() {
        final var breweryResponse = restTemplate.getForEntity(appSettings.getDataUrl(), Brewery[].class);
        final var breweries = Set.of(Objects.requireNonNull(breweryResponse.getBody()));
        log.info("getALL brewery: {}", breweries);
        return breweries;
    }
}
