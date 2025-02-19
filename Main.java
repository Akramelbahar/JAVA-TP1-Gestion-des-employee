subnet 10.0.0.0 netmask 255.255.255.0 {
    range 10.0.0.100 10.0.0.200;   # Assign IPs to containers/VMs in this range
    option routers 10.0.0.1;       # The gateway IP in the internal network
    option domain-name-servers 8.8.8.8, 8.8.4.4;  # DNS servers
}
