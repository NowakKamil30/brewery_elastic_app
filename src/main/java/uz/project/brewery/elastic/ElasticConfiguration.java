package uz.project.brewery.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfiguration {

    @Bean
    public ElasticsearchAsyncClient getElasticsearchAsyncClient() {
        final CredentialsProvider credentialsProvider =
                new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "elastic"));

        final var httpClient = RestClient.builder(
                new HttpHost("localhost", 9200)
        ).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                .setDefaultCredentialsProvider(credentialsProvider)).build();

        final var transport = new RestClientTransport(
                httpClient,
                new JacksonJsonpMapper()
        );

        return new ElasticsearchAsyncClient(transport);
    }
}
