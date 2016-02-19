package com.waynaut.parser;

import com.waynaut.parser.makeObjectsFromGTFS.*;
import com.waynaut.parser.model.*;
import com.waynaut.parser.saveCsvToSQLDatabase.ReadAndSave;

public class Application
{
    public static void main( String[] args )
    {
        System.out.println("--------\tAPPLICATION STARTS\t--------");



        System.out.println("--------\tSAVING FILES INTO DATABASE\t--------");
        ReadAndSave data=new ReadAndSave();
        data.readAndSave();
        System.out.println("--------\tSAVING FILES INTO DATABASE DONE\t--------");



        System.out.println( "--------\tMAKING OBJECTS FROM agency\t--------" );
        Object_Agency object_agency=new Object_Agency();
        Agency agency_objects[]=object_agency.getAgencyObjects();
        String agency_objects_json=object_agency.getAgencyObjectsInJsonString();
        /*
        String agency_objects_json_copy=object_agency.toString();
        System.out.println(agency_objects_json);
        System.out.println(agency_objects_json_copy);
        System.out.println(object_agency);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM agency DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM calendar\t--------" );
        Object_Calendar object_calendar=new Object_Calendar();
        Calendar calendar_objects[]=object_calendar.getCalendarObjects();
        String calendar_objects_json=object_calendar.getCalendarObjectsInJsonString();
        /*
        String calendar_objects_json_copy=object_calendar.toString();
        System.out.println(calendar_objects_json);
        System.out.println(calendar_objects_json_copy);
        System.out.println(object_calendar);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM calendar DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM calendar_dates\t--------" );
        Object_Calendar_dates object_calendar_dates=new Object_Calendar_dates();
        Calendar_dates calendar_dates_objects[]=object_calendar_dates.getCalendar_datesObjects();
        String calendar_dates_objects_json=object_calendar_dates.getCalendar_datesObjectsInJsonString();
        /*
        String calendar_dates_objects_json_copy=object_calendar_dates.toString();
        System.out.println(calendar_dates_objects_json);
        System.out.println(calendar_dates_objects_json_copy);
        System.out.println(object_calendar_dates);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM calendar_dates DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM feed_info\t--------" );
        Object_Feed_info object_feed_info=new Object_Feed_info();
        Feed_info feed_info_objects[]=object_feed_info.getFeed_infoObjects();
        String feed_info_objects_json=object_feed_info.getFeed_infoObjectsInJsonString();
        /*
        String feed_info_objects_json_copy=object_feed_info.toString();
        System.out.println(feed_info_objects_json);
        System.out.println(feed_info_objects_json_copy);
        System.out.println(object_feed_info);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM feed_info DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM frequencies\t--------" );
        Object_Frequencies object_frequencies=new Object_Frequencies();
        Frequencies frequencies_objects[]=object_frequencies.getFrequenciesObjects();
        String frequencies_objects_json=object_frequencies.getFrequenciesObjectsInJsonString();
        /*
        String frequencies_objects_json_copy=object_frequencies.toString();
        System.out.println(frequencies_objects_json);
        System.out.println(frequencies_objects_json_copy);
        System.out.println(object_frequencies);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM frequencies DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM routes\t--------" );
        Object_Routes object_routes=new Object_Routes();
        Routes routes_objects[]=object_routes.getRoutesObjects();
        String routes_objects_json=object_routes.getRoutesObjectsInJsonString();
        /*
        String routes_objects_json_copy=object_routes.toString();
        System.out.println(routes_objects_json);
        System.out.println(routes_objects_json_copy);
        System.out.println(object_routes);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM routes DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM stop_times\t--------" );
        Object_Stop_times object_stop_times=new Object_Stop_times();
        Stop_times stop_times_objects[]=object_stop_times.getStop_timesObjects();
        String stop_times_objects_json=object_stop_times.getStop_timesObjectsInJsonString();
        /*
        String stop_times_objects_json_copy=object_stop_times.toString();
        System.out.println(stop_times_objects_json);
        System.out.println(stop_times_objects_json_copy);
        System.out.println(object_stop_times);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM stop_times DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM stops\t--------" );
        Object_Stops object_stops=new Object_Stops();
        Stops stops_objects[]=object_stops.getStopsObjects();
        String stops_objects_json=object_stops.getStopsObjectsInJsonString();
        /*
        String stops_objects_json_copy=object_stops.toString();
        System.out.println(stops_objects_json);
        System.out.println(stops_objects_json_copy);
        System.out.println(object_stops);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM stops DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM transfers\t--------" );
        Object_Transfers object_transfers=new Object_Transfers();
        Transfers transfers_objects[]=object_transfers.getTransfersObjects();
        String transfers_objects_json=object_transfers.getTransfersObjectsInJsonString();
        /*
        String transfers_objects_json_copy=object_transfers.toString();
        System.out.println(transfers_objects_json);
        System.out.println(transfers_objects_json_copy);
        System.out.println(object_transfers);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM transfers DONE\t--------" );



        System.out.println( "--------\tMAKING OBJECTS FROM trips\t--------" );
        Object_Trips object_trips=new Object_Trips();
        Trips trips_objects[]=object_trips.getTripsObjects();
        String trips_objects_json=object_trips.getTripsObjectsInJsonString();
        /*
        String trips_objects_json_copy=object_trips.toString();
        System.out.println(trips_objects_json);
        System.out.println(trips_objects_json_copy);
        System.out.println(object_trips);
        //Above 3 printing statements would print the same.
         */
        System.out.println( "--------\tMAKING OBJECTS FROM trips DONE\t--------" );



        System.out.println("--------\tAPPLICATION ENDS\t--------");
    }
}
