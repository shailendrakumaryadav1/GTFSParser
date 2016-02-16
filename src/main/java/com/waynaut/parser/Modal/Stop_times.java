package com.waynaut.parser.Modal;

/**
 * Created by SKY on 2/16/2016.
 */
public class Stop_times
{
    private String trip_id;
    private String arrival_time;
    private String departure_time;
    private String stop_id;
    private int stop_sequence;
    private String stop_headsign;
    private String pickup_type;
    private String drop_off_type;
    private String shape_dist_traveled;
    private String attributes_ch;

    public String getTrip_id()
    {
        return trip_id;
    }

    public void setTrip_id(String trip_id)
    {
        this.trip_id = trip_id;
    }

    public String getArrival_time()
    {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time)
    {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time()
    {
        return departure_time;
    }

    public void setDeparture_time(String departure_time)
    {
        this.departure_time = departure_time;
    }

    public String getStop_id()
    {
        return stop_id;
    }

    public void setStop_id(String stop_id)
    {
        this.stop_id = stop_id;
    }

    public int getStop_sequence()
    {
        return stop_sequence;
    }

    public void setStop_sequence(int stop_sequence)
    {
        this.stop_sequence = stop_sequence;
    }

    public String getStop_headsign()
    {
        return stop_headsign;
    }

    public void setStop_headsign(String stop_headsign)
    {
        this.stop_headsign = stop_headsign;
    }

    public String getPickup_type()
    {
        return pickup_type;
    }

    public void setPickup_type(String pickup_type)
    {
        if(pickup_type.equals(""))
            this.pickup_type = "0";
        else
            this.pickup_type = pickup_type;
    }

    public String getDrop_off_type()
    {
        return drop_off_type;
    }

    public void setDrop_off_type(String drop_off_type)
    {
        if(drop_off_type.equals(""))
            this.drop_off_type="0";
        else
            this.drop_off_type = drop_off_type;
    }

    public String getShape_dist_traveled()
    {
        return shape_dist_traveled;
    }

    public void setShape_dist_traveled(String shape_dist_traveled)
    {
        this.shape_dist_traveled = shape_dist_traveled;
    }

    public String getAttributes_ch()
    {
        return attributes_ch;
    }

    public void setAttributes_ch(String attributes_ch)
    {
        this.attributes_ch = attributes_ch;
    }

}
