package com.waynaut.parser.model;

import static sun.plugin2.util.PojoUtil.toJson;

public class Calendar_dates
{
    public String service_id;
    public String date;
    public int exception_type;

    public String getService_id()
    {
        return service_id;
    }

    public void setService_id(String service_id)
    {
        this.service_id = service_id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getException_type()
    {
        return exception_type;
    }

    public void setException_type(int exception_type)
    {
        this.exception_type = exception_type;
    }

    public void setException_type(String exception_type)
    {
        this.exception_type = Integer.parseInt(exception_type);
    }

    @Override
    public String toString()
    {
        return toJson(this);
    }
}
