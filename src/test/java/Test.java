import com.gridnine.testing.AirFlightFilter;
import org.junit.Assert;
import org.junit.Before;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {
    @org.junit.Test
    void betweenTest(){
        AirFlightFilter airFlightFilter = new AirFlightFilter();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now().plusHours(3);
        int actual = airFlightFilter.between(now,now2);
        Assert.assertEquals(3,actual);
    }

}