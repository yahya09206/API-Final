package com.yahya.tests.Day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.HRTestBase;
import org.junit.jupiter.api.Test;

public class API_DB_Test extends HRTestBase {

    @Test
    public void testRegion(){


        DB_Util.runQuery("SELECT * FROM REGIONS");
        // find the row count
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());
        DB_Util.displayAllData();
    }

    /**
     * Send API request to http://44.211.192.252:1000/ords/hr/regions
     * Get your response
     * Get the expected count from Database
     * Assert the api request response has some count as database row count
     */
    @Test
    public void testRegionsCount(){

        // Prepare expected result here
        DB_Util.runQuery("SELECT * FROM REGIONS");
        int expectedCount = DB_Util.getRowCount();
    }
}
