package com.demo.base;

import com.demo.grpc.helloService.HelloRequest;
import com.demo.grpc.helloService.HelloResponse;
import com.demo.grpc.helloService.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest helloRequest, StreamObserver<HelloResponse> responseStreamObserver) {
        String greeting = new StringBuilder()
                .append("hello, ")
                .append(helloRequest.getFirstName())
                .append(" ")
                .append(helloRequest.getLastName())
                .toString();

        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseStreamObserver.onNext(helloResponse);
        responseStreamObserver.onCompleted();
    }
}
