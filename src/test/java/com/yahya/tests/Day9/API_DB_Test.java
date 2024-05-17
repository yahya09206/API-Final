package com.yahya.tests.Day9;

import com.yahya.utility.DB_Util;
import org.junit.jupiter.api.Test;

public class API_DB_Test {

    @Test
    public void testRegion(){

        DB_Util.createConnection();
        DB_Util.runQuery("SELECT * FROM REGIONS");
        DB_Util.displayAllData();
        DB_Util.destroy();
    }
}
