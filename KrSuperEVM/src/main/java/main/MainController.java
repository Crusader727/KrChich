package main;

import main.dao.MainDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class MainController {
    private MainDAO dao;
    private Random rand;

    public MainController(MainDAO md) {
        dao = md;
//        if (false) {
        rand = new Random();
        dao.createUnderground("Moscow");
        for(int i = 0; i < 100; i++)
            dao.createBranch("Branch#"+i+1,"Color#"+i+1,1);
        for(int i = 0; i < 10000; i++)
            dao.createStation("Station#"+1+i, rand.nextInt(100)+1);
        for(int i = 0; i < 10000; i++)
            dao.createTrain(rand.nextInt(100000), rand.nextInt(100)+1);
        for(int i=0; i < 60000; i++)
            dao.createCarriage(rand.nextInt(600000),rand.nextInt(10000)+1,rand.nextInt(50)+50);
        for(int i=0; i < 1000; i++)
            dao.createBranchStats(getRandomDate(), rand.nextInt(100)+1,
                    rand.nextInt(10000)+2000,rand.nextInt(10000)+2000);
        for(int i = 0; i < 100000; i++)
            dao.createStationStats(getRandomDate(),rand.nextInt(10000)+1, rand.nextBoolean());
//        }
        System.out.println("Finished");
    }

    private Timestamp getRandomDate() {
        long offset = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long) (Math.random() * diff));
    }

}
