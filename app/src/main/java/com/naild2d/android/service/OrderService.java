package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public interface OrderService extends Service {
    public OrderServiceInfo getOrderService(int id);

    public String getAddress(String phone, double lat, double lon);

    //Todo:modify schedule method to new api
    public String[] getSchedule(int packageId);

    public int order(String phone, int[] serviceId, int scheduleId,
                     String location, String address,
                     double lat, double lon, String remark);

    public OrderInfo getOrder(int orderId);


}
