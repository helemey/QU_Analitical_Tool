package com.model.dataType;

import com.model.Constants;

public class Service {
    private String serviceId;
    private String variationId;

    public void setService(String serviceId, String variationId) {
        this.serviceId = serviceId;
        this.variationId = variationId;
    }

    public void setService(String serviceId) {
        setService(serviceId, null);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Service service = (Service) object;
        if (!serviceId.equals(service.serviceId)) {
            return false;
        }
        return variationId == null || variationId.equals(service.variationId);
    }

    @Override
    public int hashCode() {
        int result = serviceId.hashCode();
        result = 31 * result + (variationId != null ? variationId.hashCode() : 0);
        return result;
    }

    public boolean isServiceEquals(Service record) {
        return (this.serviceId.equals(Constants.SPECIAL_VALUE) || this.equals(record));
    }
}
