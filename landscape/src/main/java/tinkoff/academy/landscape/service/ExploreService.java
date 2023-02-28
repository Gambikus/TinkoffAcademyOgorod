package tinkoff.academy.landscape.service;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tinkoff.academy.landscape.configuration.ServicesProperties;
import tinkoff.academy.landscape.dto.ExploreResponse;
import tinkoff.academy.landscape.model.ServiceInfo;
import tinkoff.academy.proto.ReadinessResponse;
import tinkoff.academy.proto.StatusServiceGrpc;
import tinkoff.academy.proto.VersionResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExploreService {

    private final ServicesProperties servicesProperties;

    public List<ExploreResponse> exploreAllServices() {
        List<ExploreResponse> servicesInfo = new ArrayList<>();

        for (ServiceInfo handymanService :
                servicesProperties.getHandymanServices()) {
            servicesInfo.add(exploreService(handymanService.getPort(), handymanService.getHost()));
        }

        for (ServiceInfo rancherService :
                servicesProperties.getRancherServices()) {
            servicesInfo.add(exploreService(rancherService.getPort(), rancherService.getHost()));
        }

        return servicesInfo;
    }

    private ExploreResponse exploreService(int port, String host) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        StatusServiceGrpc.StatusServiceBlockingStub statusServiceStub = StatusServiceGrpc.newBlockingStub(channel);

        ReadinessResponse readinessResponse = statusServiceStub.getReadiness(Empty.newBuilder().build());
        VersionResponse versionResponse = statusServiceStub.getVersion(Empty.newBuilder().build());

        channel.shutdown();

        return ExploreResponse.builder()
                .host(host + ":" + port)
                .status(readinessResponse.getStatus())
                .artifact(versionResponse.getArtifact())
                .name(versionResponse.getName())
                .group(versionResponse.getGroup())
                .version(versionResponse.getVersion())
                .build();
    }
}
