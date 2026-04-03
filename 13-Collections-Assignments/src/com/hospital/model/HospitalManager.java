package com.hospital.model;

import java.util.*;

import com.hospital.model.Patient;

public class HospitalManager {

    private Set<Patient> patientSet = new HashSet<>();
    private Queue<Patient> queue = new LinkedList<>();

    // Doctor-wise mapping
    private Map<String, List<Patient>> doctorMap = new HashMap<>();

    // Add patient with doctor
    public boolean addPatient(Patient p, String doctorName) {

        if (patientSet.add(p)) {

            queue.offer(p);

            doctorMap.putIfAbsent(doctorName, new ArrayList<>());
            doctorMap.get(doctorName).add(p);

            return true;
        }
        return false;
    }

    // Process next patient (token system)
    public Patient processNextPatient() {
        return queue.poll();
    }

    // Get patients by doctor
    public List<Patient> getPatientsByDoctor(String doctor) {
        return doctorMap.getOrDefault(doctor, new ArrayList<>());
    }

    // Sort patients by age
    public List<Patient> getSortedPatients() {
        List<Patient> list = new ArrayList<>(patientSet);
        Collections.sort(list);
        return list;
    }

    // Safe removal (discharge)
    public void dischargePatient(int id) {

        Iterator<Patient> it = patientSet.iterator();

        while (it.hasNext()) {
            Patient p = it.next();

            if (p.getPatientId() == id) {

                it.remove();         
                queue.remove(p);      

                // remove from doctor map
                for (List<Patient> list : doctorMap.values()) {
                    list.remove(p);
                }

                System.out.println("Discharged: " + p.getName());
            }
        }
    }
}