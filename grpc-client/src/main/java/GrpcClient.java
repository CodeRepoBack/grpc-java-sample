import com.demo.grpc.helloService.HelloRequest;
import com.demo.grpc.helloService.HelloResponse;
import com.demo.grpc.helloService.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
        .setFirstName("Jake")
        .setLastName("Seo")
        .build());

        System.out.println(helloResponse);

        channel.shutdown();
    }
}
