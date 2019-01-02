package com.cloud.jsproducerremittance.service;

import com.cloud.jsproducerremittance.entity.MakeRemittance;

public interface MakeAnAppointmentToTheRemittanceService {
    MakeRemittance addMakeAnAppointmentToTheRemittance(MakeRemittance makeRemittance);
    void addMakeAnAppointment(MakeRemittance makeRemittance);
}
