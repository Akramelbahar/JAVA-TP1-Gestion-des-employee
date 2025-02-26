# Define the default lease time
default-lease-time 600;
max-lease-time 7200;

# Authoritative DHCP server
authoritative;

# First network on eth0 (192.168.1.0/24)
subnet 192.168.1.0 netmask 255.255.255.0 {
    range 192.168.1.100 192.168.1.200;
    option routers 192.168.1.1;
    option subnet-mask 255.255.255.0;
    option domain-name-servers 8.8.8.8, 8.8.4.4;
}

# Second network on eth1 (10.10.10.0/24)
subnet 10.10.10.0 netmask 255.255.255.0 {
    range 10.10.10.50 10.10.10.150;
    option routers 10.10.10.1;
    option subnet-mask 255.255.255.0;
    option domain-name-servers 1.1.1.1, 1.0.0.1;
}
