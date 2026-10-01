package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_result() {
        assertEquals(team, team);
        assertNotEquals(team, null);
        Team anotherTeam = new Team("test-team");
        assertEquals(team, anotherTeam);
        anotherTeam.addMember("member1");
        assertNotEquals(team, anotherTeam);
        Team yetAnotherTeam = new Team("different-team");
        assertNotEquals(team, yetAnotherTeam);
        yetAnotherTeam.addMember("member1");
        assertNotEquals(team, yetAnotherTeam);
    }
    
    @Test
    public void hashCode_returns_correct_result() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        t2.addMember("baz");
        assertNotEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team();
        t.setName("foo");
        int result = t.hashCode();
        int expectedResult = 101575;
        assertEquals(expectedResult, result);
    }
}
