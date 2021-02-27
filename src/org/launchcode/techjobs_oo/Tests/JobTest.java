package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;

    @Before
    public void before(){
        job1 = new Job();
        job2 = new Job();

    }

    @Test
    public void testSettingJobId(){
        assertEquals(1, job2.getId(), job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertTrue(job instanceof Job);
        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("Desert", job.getLocation().getValue());
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Quality control", job.getPositionType().getValue());
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToString(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Boolean beginning = job.toString().startsWith("\n");
        Boolean end = job.toString().endsWith("\n");
        Boolean compare = end == beginning;
        assertEquals(true, compare);
    }

    @Test
    public void testFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + job.getId() + "\nName: " + job.getName() + "\nEmployer: " + job.getEmployer() + "\nLocation: " + job.getLocation() + "\nPosition Type: " + job.getPositionType() + "\nCore Competency: " + job.getCoreCompetency() + "\n";
        assertEquals(expected, job.toString());
    }

    @Test
    public void testEmptyFields() {
        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + job.getId() + "\nName: " + "Data Not Available" + "\nEmployer: " + job.getEmployer() + "\nLocation: " + job.getLocation() + "\nPosition Type: " + job.getPositionType() + "\nCore Competency: " + job.getCoreCompetency() + "\n";
        assertEquals(expected, job.toString());
    }

    @Test
    public void testIDField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = "OOPS! This job does not seem to exist.";
        assertEquals(expected, job.toString());
    }

}
