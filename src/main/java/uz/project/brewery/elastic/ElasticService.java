package uz.project.brewery.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import uz.project.brewery.brewery.Brewery;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ElasticService {
    private final ElasticsearchAsyncClient esClient;

    public void addData(final Brewery brewery) {
        esClient.indices().create(c -> c.index("brewery1"));
        esClient.index(i -> i
                        .index("brewery1")
                        .id(randomUUID().toString())
                        .document(brewery))
                .whenComplete(((indexResponse, throwable) -> {
                    if (throwable != null) {
                        log.error("Failed to index", throwable);
                    } else {
                        log.info("Indexed with version " + indexResponse.version());
                    }
                }));
    }
}
