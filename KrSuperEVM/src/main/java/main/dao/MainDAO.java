package main.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Service
public class MainDAO {


    private final JdbcTemplate template;

    @Autowired
    public MainDAO(JdbcTemplate template) {
        this.template = template;
    }

    public void createUnderground(String city) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into underground(city)"
                            + " values(?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, city);
            return pst;
        }, keyHolder);

    }

    public void createTrain(Integer serial, Integer branchID) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into train(serialno, branch_id)"
                            + " values(?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, serial);
            pst.setInt(2, branchID);
            return pst;
        }, keyHolder);

    }

    public void createStationStats(Timestamp date, Integer stationId, Boolean entered) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into station_stats(date, station_id, entered)"
                            + " values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setTimestamp(1, date);
            pst.setInt(2, stationId);
            pst.setBoolean(3, entered);
            return pst;
        }, keyHolder);

    }

    public void createStation(String name, Integer branchID) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into station(name, branch_id)"
                            + " values(?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setInt(2, branchID);
            return pst;
        }, keyHolder);

    }

    public void createCarriage(Integer serial, Integer trainId, Integer seats) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into carriage(serialno, seats, train_id)"
                            + " values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, serial);
            pst.setInt(2, seats);
            pst.setInt(3, trainId);
            return pst;
        }, keyHolder);
    }

    public void createBranchStats(Timestamp date, Integer branchid,
                                  Integer enteredAmount, Integer exitedAmount) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into branch_stats(branch_id, date, entered_amount, exited_amount)"
                            + " values(?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, branchid);
            pst.setTimestamp(2, date);
            pst.setInt(3, enteredAmount);
            pst.setInt(4, exitedAmount);
            return pst;
        }, keyHolder);
    }
  public void createBranch(String name, String  color,
                                  Integer undergroundId) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into branch(name, color, underground_id)"
                            + " values(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setString(2, color);
            pst.setInt(3, undergroundId);
            return pst;
        }, keyHolder);
    }


//    public ArrayList<Pair<String, Integer>> getWorkers() {
//        ArrayList<Pair<String, Integer>> result = new ArrayList<>();
//        Integer viceCount = getCount("vice");
//        result.add(new Pair<String, Integer>("Vice: " + viceCount, viceCount));
//        Integer headmasterCount = getCount("headmaster");
//        result.add(new Pair<String, Integer>("Headmaster: " + headmasterCount, headmasterCount));
//        Integer guideCount = getCount("guide");
//        result.add(new Pair<String, Integer>("Guide: " + guideCount, guideCount));
//        Integer guardCount = getCount("guard");
//        result.add(new Pair<String, Integer>("Guard: " + guardCount, guardCount));
//        Integer managerCount = getCount("manager");
//        result.add(new Pair<String, Integer>("Manager: " + managerCount, managerCount));
//        return result;
//    }
//
//    public Integer getCount(String position) {
//        return template.queryForObject(
//                "select count(*) from employee where position = CAST(? as post);",
//                new Object[]{position}, Integer.class);
//    }
}



