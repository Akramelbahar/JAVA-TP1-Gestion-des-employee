If you're using the dhcpd server (ISC DHCP server) and want to configure it to listen on multiple interfaces, you need to follow these steps. I'll guide you through the process of specifying which interfaces the dhcpd server should use and configuring the subnets properly.

Step 1: Identify the Network Interfaces
Before configuring the DHCP server, ensure that the network interfaces are properly set up and identified. You can use the following command to list all the available network interfaces:

bash
Copy
ip a
You should see interfaces such as eth0, eth1, ens33, etc. Decide which interfaces you want the dhcpd server to listen on.

Step 2: Configure dhcpd.conf for Multiple Interfaces
The dhcpd.conf file contains the settings for the DHCP server, including the IP address ranges to assign for each subnet. For each interface that you want the server to listen on, you must define the corresponding subnet settings.

Open the DHCP configuration file:

bash
Copy
sudo nano /etc/dhcp/dhcpd.conf
Configure subnets for the interfaces. For example, if you're using eth0 with the 192.168.1.0/24 network and eth1 with the 192.168.2.0/24 network, you would configure the subnets like this:

bash
Copy
# DHCP configuration for eth0 (192.168.1.0/24)
subnet 192.168.1.0 netmask 255.255.255.0 {
    range 192.168.1.100 192.168.1.200;
    option routers 192.168.1.1;  # Gateway for this subnet
    option domain-name-servers 8.8.8.8, 8.8.4.4;  # DNS servers
}

# DHCP configuration for eth1 (192.168.2.0/24)
subnet 192.168.2.0 netmask 255.255.255.0 {
    range 192.168.2.100 192.168.2.200;
    option routers 192.168.2.1;  # Gateway for this subnet
    option domain-name-servers 8.8.8.8, 8.8.4.4;  # DNS servers
}
Each subnet block corresponds to an interface. Make sure to adjust the range, option routers, and option domain-name-servers according to your network setup.

Save and close the file (Ctrl+X, then Y, then Enter).

Step 3: Specify Interfaces for the DHCP Server to Bind to
You now need to configure the DHCP server to listen on the specified interfaces. Depending on your system, the process can vary slightly.

For Debian/Ubuntu-based systems:
Open the configuration file for the DHCP server:

bash
Copy
sudo nano /etc/default/isc-dhcp-server
In this file, look for the INTERFACES line. By default, this may be empty. Set the interfaces that the DHCP server should listen on. For example:

bash
Copy
INTERFACES="eth0 eth1"
This configuration ensures that the DHCP server listens on both eth0 and eth1.

Save and close the file.

For RHEL/CentOS/Fedora-based systems:
Open the configuration file for the DHCP daemon:

bash
Copy
sudo nano /etc/sysconfig/dhcpd
In this file, set the DHCPDARGS variable to specify which interfaces the server should use. For example:

bash
Copy
DHCPDARGS="eth0 eth1"
Save and close the file.

Step 4: Restart the DHCP Service
Once you’ve configured the DHCP server to listen on multiple interfaces and specified the subnets in dhcpd.conf, you need to restart the dhcpd service for the changes to take effect.

Restart the DHCP server:

On Debian/Ubuntu-based systems:

bash
Copy
sudo systemctl restart isc-dhcp-server
On RHEL/CentOS/Fedora-based systems:

bash
Copy
sudo systemctl restart dhcpd
Verify the DHCP server status to make sure it is running correctly:

On Debian/Ubuntu-based systems:

bash
Copy
sudo systemctl status isc-dhcp-server
On RHEL/CentOS/Fedora-based systems:

bash
Copy
sudo systemctl status dhcpd
Step 5: Verify the DHCP Leases
After restarting the DHCP server, you can check the leases to ensure that IP addresses are being assigned properly.

Check the DHCP leases:

bash
Copy
sudo cat /var/lib/dhcp/dhcpd.leases
This file will contain a record of the IP addresses that have been assigned to clients.

Step 6: Test the DHCP Server
To test that the DHCP server is working correctly, make sure a client (such as another VM or machine) is set to obtain an IP address via DHCP and is connected to the network corresponding to the interface.

Check the client’s IP address after the lease: On the client machine, run:

bash
Copy
ip a
The IP address should fall within the range you defined in the dhcpd.conf file (e.g., 192.168.1.100-200 for eth0 or 192.168.2.100-200 for eth1).

Conclusion
By configuring dhcpd to listen on multiple interfaces, you enable the DHCP server to serve multiple subnets, each with its own IP range. You need to:

Configure subnets in the dhcpd.conf file.
Specify the interfaces the DHCP server should listen on in the system configuration files.
Restart the service to apply the changes.
This setup is useful when you need to manage DHCP services across different networks or when running multiple VMs/containers that need dynamic IP assignments.
