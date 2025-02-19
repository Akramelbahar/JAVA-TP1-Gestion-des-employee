# Basic DHCP configuration

option domain-name "example.com";
option domain-name-servers 8.8.8.8, 8.8.4.4;  # Google's DNS servers

default-lease-time 600;
max-lease-time 7200;

# Subnet definition for 10.0.2.0/24 network (This is typically used in NAT mode in VirtualBox)
subnet 10.0.2.0 netmask 255.255.255.0 {
    range 10.0.2.100 10.0.2.200;  # Assign IPs between 10.0.2.100 and 10.0.2.200
    option routers 10.0.2.2;      # Gateway IP (this is the VirtualBox NAT router IP)
    option broadcast-address 10.0.2.255;  # Broadcast address
    option domain-name-servers 8.8.8.8, 8.8.4.4;
}
