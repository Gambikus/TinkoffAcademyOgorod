package tinkoff.academy.landscape.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import tinkoff.academy.landscape.model.ServiceInfo;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "services")
@ConfigurationPropertiesScan
@Getter
@Setter
public class ServicesProperties {

    private List<ServiceInfo> handymanServices;

    private List<ServiceInfo> rancherServices;
}
