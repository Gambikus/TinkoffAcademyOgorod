package tinkoff.academy.landscape.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExploreResponse {
    private String host;

    private String status;

    private String artifact;

    private String name;

    private String group;

    private String version;
}
