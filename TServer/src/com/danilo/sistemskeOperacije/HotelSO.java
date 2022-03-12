package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Hotel;

public class HotelSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		Hotel hotel = (Hotel) object;
        IBroker ib = new Broker();
        ib.sacuvaj(hotel);
	}

}
