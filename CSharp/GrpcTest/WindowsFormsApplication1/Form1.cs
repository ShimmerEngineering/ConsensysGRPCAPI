using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net.Sockets;
using System.Net;
using System.IO;
using System.Diagnostics;
using Grpc.Core;
using com.shimmerresearch.grpc;



namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        ShimmerGrpcImpl test = new ShimmerGrpcImpl();
        public Form1()
        {
            InitializeComponent();
        
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            /*
            Channel channel = new Channel("127.0.0.1:50051", ChannelCredentials.Insecure);
            var client = Greeter.NewClient(channel);
            var reply = client.SayHello(new HelloRequest { Name = "Lim Jong Chern" });
            Console.WriteLine("Greeting: " + reply.Message);
             */
            
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            test.Connect(textBox1.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            test.Disconnect();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            test.StartStreaming();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            test.StopStreaming();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private async void button5_Click(object sender, EventArgs e)
        {
            try {
                await test.Connect(textBoxAddress.Text, textBoxPort.Text);
                labelClient.Text = "Client Is Connected";
                test.Start();
            } catch(Exception Ex)
            {
                labelClient.Text = "Client Is Not Connected";
            }
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void textBoxAddress_TextChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button6_Click(object sender, EventArgs e)
        {
            listView1.Columns.Clear();
            listView1.Items.Clear();
            listView1.View = View.Details;
            listView1.Columns.Add("Name");
            listView1.Columns.Add("COM port");

            var shimmersInfo = test.ListDevices();
            var shimmerNames = new List<string>();
            foreach(var pair in shimmersInfo.ShimmerMap)
            {
                var shimmer = pair.Value;
                shimmerNames.Add(shimmer.Name);
                listView1.Items.Add(new ListViewItem(new string[] { shimmer.Name, shimmer.UniqueId }));
            }
            listView1.Refresh();
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string comport = listView1.SelectedItems[0].SubItems[1].Text;
            test.Connect(comport);
        }
    }
}
