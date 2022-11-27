package uz.project.brewery.brewery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Brewery {
    private String id;
    private String name;
    @JsonProperty("brewery_type")
    private String breweryType;
    private String street;
    @JsonProperty("address_2")
    private String address2;
    @JsonProperty("address_3")
    private String address3;
    private String city;
    private String state;
    @JsonProperty("county_province")
    private String countyProvince;
    @JsonProperty("postal_code")
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    @JsonProperty("website_url")
    private String website_url;
    @JsonProperty("updated_at")
    private String updated_at;
    @JsonProperty("created_at")
    private String created_at;
}
