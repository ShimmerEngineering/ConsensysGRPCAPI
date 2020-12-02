using com.shimmerresearch.grpc;
using System;

namespace DataTesting
{
    class Program
    {
        static void Main(string[] args)
        {
            ShimmerTestGrpcImpl test = new ShimmerTestGrpcImpl();
            test.Connect("localhost","50051");
            test.Start();

            Console.ReadKey();
        }
    }
}
