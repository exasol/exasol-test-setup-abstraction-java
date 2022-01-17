package com.exasol.exasoltestsetup;

import java.util.Objects;
import java.util.Set;

import com.exasol.errorreporting.ExaError;

/**
 * This class represents a TCP service address with hostname and port.
 */
public class ServiceAddress {
    private final String hostName;
    private final int port;

    /**
     * Create a new {@link ServiceAddress}.
     * 
     * @param hostName host name
     * @param port     port
     */
    public ServiceAddress(final String hostName, final int port) {
        this.hostName = hostName;
        this.port = port;
    }

    /**
     * Create a {@link ServiceAddress} for a local service.
     * 
     * @param port port number
     * @return service address
     */
    public static ServiceAddress local(final int port) {
        return new ServiceAddress("localhost", port);
    }

    /**
     * Get a {@link ServiceAddress} from string in format host:ip.
     * 
     * @param address address string in format host:ip
     * @return built address
     * @throws IllegalArgumentException if the address has an invalid format
     */
    public static ServiceAddress parse(final String address) {
        final String[] parts = address.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException(ExaError.messageBuilder("E-ETAJ-18")
                    .message("Invalid service address {{address}}. The address must have the format host:port.",
                            address)
                    .toString());
        }
        return new ServiceAddress(parts[0], Integer.parseInt(parts[1]));
    }

    /**
     * Get the host name.
     * 
     * @return host name
     */
    public String getHostName() {
        return this.hostName;
    }

    /**
     * Get the port.
     * 
     * @return port
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Get if this is a local address. (host = localhost)
     * 
     * @return {@code true} if it's a local address
     */
    public boolean isLocal() {
        return Set.of("localhost", "127.0.0.1").contains(this.getHostName());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final ServiceAddress that = (ServiceAddress) o;
        return this.port == that.port && Objects.equals(this.hostName, that.hostName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hostName, this.port);
    }

    @Override
    public String toString() {
        return this.getHostName() + ":" + getPort();
    }
}
