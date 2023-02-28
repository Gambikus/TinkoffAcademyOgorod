package tinkoff.academy.handyman.service;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import tinkoff.academy.proto.ReadinessResponse;
import tinkoff.academy.proto.StatusServiceGrpc;
import tinkoff.academy.proto.VersionResponse;

import java.util.Map;

@GrpcService
public class GrpcStatusServiceImpl extends StatusServiceGrpc.StatusServiceImplBase {

    @Autowired
    private SystemStatusService systemStatusService;

    @Override
    public void getReadiness(com.google.protobuf.Empty request,
                             StreamObserver<ReadinessResponse> responseObserver) {
        Map<String, String> readiness = systemStatusService.GetReadiness();
        ReadinessResponse readinessResponse;
        if (readiness.containsKey("reason")) {
            readinessResponse = ReadinessResponse.newBuilder().setStatus("OFF").build();
        } else {
            readinessResponse = ReadinessResponse.newBuilder().setStatus("OK").build();
        }

        responseObserver.onNext(readinessResponse);
        responseObserver.onCompleted();
    }
    @Override
    public void getVersion(com.google.protobuf.Empty request,
                           StreamObserver<VersionResponse> responseObserver) {
        Map<String, String> version = systemStatusService.GetVersion();

        VersionResponse versionResponse = VersionResponse
                .newBuilder()
                .setVersion(version.get("version"))
                .setArtifact(version.get("artifact"))
                .setGroup(version.get("group"))
                .setName(version.get("name"))
                .build();

        responseObserver.onNext(versionResponse);
        responseObserver.onCompleted();
    }
}
