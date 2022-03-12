package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.UslugeHotel;

public class UslugeHotelSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		UslugeHotel uslugeHotel = (UslugeHotel) object;
		IBroker ib = new Broker();
		ib.sacuvaj(uslugeHotel);

	}

}
