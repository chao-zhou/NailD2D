package com.naild2d.android.service;

/**
 * Service Config
 * Created by chao_zhou on 15/1/26.
 */
public class ServiceConfig {

    public static final String DefaultHost = "localhost";

    private static final String UrlFormatter = "%1$s://%2$s:%3$d";

    //Static
    private static ServiceConfig defaultService;
    //Instance
    private String host;
    private int port;
    private boolean isSSL;

    public ServiceConfig() {
        this(DefaultHost);
    }

    public ServiceConfig(String host) {
        this(host, 80, false);
    }

    public ServiceConfig(String host, int port, boolean isSSL) {
        this.host = host;
        this.port = port;
        this.isSSL = isSSL;
    }

    public static ServiceConfig getDefaultService() {
        if (defaultService == null)
            defaultService = new ServiceConfig();
        return defaultService;
    }

    public static void setDefaultService(ServiceConfig config) {
        defaultService = config;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean isSSL) {
        this.isSSL = isSSL;
    }

    public String getHostUrl() {
        String protocol = isSSL ? "https" : "http";
        return String.format(UrlFormatter, protocol, host, protocol);
    }
}
