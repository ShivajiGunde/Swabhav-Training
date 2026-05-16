package com.studentcourse.model;

public class Course {
	
	    private int id;
	    private String courseName;
	    private String duration;
	    private double fees;
	    private String trainerName;

    public Course() {
	    }

	    public Course(int id, String courseName, String duration, double fees, String trainerName) {
	        this.id = id;
	        this.courseName = courseName;
	        this.duration = duration;
	        this.fees = fees;
	        this.trainerName = trainerName;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public void setCourseName(String courseName) {
	        this.courseName = courseName;
	    }

	    public String getDuration() {
	        return duration;
	    }

	    public void setDuration(String duration) {
	        this.duration = duration;
	    }

	    public double getFees() {
	        return fees;
	    }

	    public void setFees(double fees) {
	        this.fees = fees;
	    }

	    public String getTrainerName() {
	        return trainerName;
	    }

	    public void setTrainerName(String trainerName) {
	        this.trainerName = trainerName;
	    }

	    @Override
	    public String toString() {
	        return "Course{" +
	                "id=" + id +
	                ", courseName='" + courseName + '\'' +
	                ", duration='" + duration + '\'' +
	                ", fees=" + fees +
	                ", trainerName='" + trainerName + '\'' +
	                '}';
	    }
	}

