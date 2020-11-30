using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using com.shimmerresearch.grpc;
using Grpc.Core;
using MathNet.Numerics.Statistics;

namespace com.shimmerresearch.grpc
{
    class ShimmerTestGrpcImpl 
    {
        ShimmerServer.ShimmerServerClient client;
        int count = 0;
        public ShimmerTestGrpcImpl(){


            
        }

        public async Task Connect(string address, string port)
        {
            try
            {
                Channel channel = new Channel(address + ":" + port, ChannelCredentials.Insecure);
                client = new ShimmerServer.ShimmerServerClient(channel);
                client.SayHello(new HelloRequest());
            } catch (Exception ex)
            {
                throw ex;
            }
            
        }
        private static readonly DateTime UnixEpoch =
    new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);


        public static long GetCurrentUnixTimestampMillis()
        {
            return (long)(DateTime.UtcNow - UnixEpoch).TotalMilliseconds;
        }
        public async Task Start()
        {
            List<double> TSDelay = new List<double>();
            List<double> TSOJCDelay = new List<double>();

            var call = client.GetDataStream(new StreamRequest());
            double lastTS = -1;
            while (await call.ResponseStream.MoveNext())
            {
                var ojc = call.ResponseStream.Current;
                count++;

                ObjectCluster2.Types.FormatCluster2 fc = ojc.DataMap.GetValueOrDefault("System_Timestamp");
                ObjectCluster2.Types.FormatCluster2.Types.DataCluster2 data = fc.FormatMap.GetValueOrDefault("CAL");
                double TS = data.Data;
                double delay = GetCurrentUnixTimestampMillis() - TS;
                if (lastTS != -1)
                {
                    double ojcdelay = TS - lastTS;
                    TSOJCDelay.Add(ojcdelay);
                }
                lastTS = TS;
                TSDelay.Add(delay);
                if (count % 48000 == 0)
                {
                    var statistics = new DescriptiveStatistics(TSDelay.ToArray().AsEnumerable());
                    var statistics2 = new DescriptiveStatistics(TSOJCDelay.ToArray().AsEnumerable());
                    Console.WriteLine("Packet Count Received:" + count + " ; Avg Delay (ms) :" + statistics.Mean + " ; Delay Between OJC (ms):" + statistics2.Mean );
                }
            }
        }

    }
}
