package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Hotel;
import com.danilo.domen.OpstiDomen;

public class PoslednjiUnetiHotelSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
             List<OpstiDomen>listHotel = (List<OpstiDomen>) object;
             IBroker ib = new Broker();
             listHotel.addAll(ib.vratiPoslednjiPodatakBaza(new Hotel()));
	}

}
